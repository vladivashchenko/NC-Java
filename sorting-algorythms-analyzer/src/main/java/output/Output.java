package output;

import analyzer.Analyzer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Class that used to output results into the Excel file.
 *
 *</p>
 */
public class Output {

    private static String FILE = "Sort-analyzer.xlsx";
    private static String TABLE_HEADER = "Lengths/Sorters";
    private static int FIRST_LENGTH_ROW = 1;
    private static int SORTERS_ROW = 0;
    private static int FIRST_LENGTH_COL = 0;
    private static int LAST_LENGTH_COL = 0;
    private static int FIRST_DURATION_ROW = 1;

    Analyzer analyzer = new Analyzer();
    /**
     * <p>
     *     Method used to write results to Excel file.
     * </p>
     * <p>
     *     Uses <b>Apache Poi</b> and <b>Apache poi OOXML</b> library.
     * </p>
     * <p> The method uses {@link #createTable(Set, Set, Map, XSSFSheet)},
     *     {@link #drawChart(XSSFSheet, int, int)} methods to create table  and draw charts in sheets.
     * </p>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi">apache poi</a>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml">apache poi ooxml</a>
     */
    public void writeToExcel() throws IOException {
        Map<String,Map<String,Map<Integer,Long>>> result;
        result = analyzer.analyze();
        XSSFWorkbook book = new XSSFWorkbook();

        for(String key : result.keySet()){
            XSSFSheet sheet = book.createSheet(key);
            Map<String,Map<Integer,Long>> data = result.get(key);
            Set<String> sorters = data.keySet();
            Set<Integer> lengths = new HashSet<Integer>();
            for(String sorter:sorters){
                Map<Integer,Long> sorterDuration = data.get(sorter);
                lengths = sorterDuration.keySet();
                createTable(sorters,lengths,data,sheet);
            }
            int lengthSize = lengths.size();
            int sortersSize = sorters.size();

            drawChart(sheet,sortersSize,lengthSize);
        }
        try {
            OutputStream os =new FileOutputStream(FILE);
            book.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            book.close();
        }
    }
    /**
     * <p>
     *     Method used to create table in Excel file.
     * </p>
     * <p>
     *     Uses <b>Apache Poi</b> and <b>Apache poi OOXML</b> library.
     * </p>
     * <p>
     *     The method uses {@link #initTable(Set, XSSFSheet)} method to init table.
     * </p>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi">apache poi</a>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml">apache poi ooxml</a>
     */
    private void createTable(Set<String> sorters,Set<Integer> lengths,Map<String,Map<Integer,Long>> data, XSSFSheet sheet){
        int rowNum=0;
        int colNum=0;
        initTable(sorters,sheet);
        for(Integer length:lengths){
            Row row = sheet.createRow(++rowNum);
            Cell cell = row.createCell(colNum);
            cell.setCellValue(length);
            for(String sorter:sorters){
                Map<Integer,Long> sorterDuration = data.get(sorter);
                cell = row.createCell(++colNum);
                Long duration = sorterDuration.get(length);
                cell.setCellValue(duration);
            }
            colNum = 0;
        }
    }
    /**
     * <p>
     *     Method used to initialize table in Excel file.
     * </p>
     * <p>
     *     Uses <b>Apache Poi</b> and <b>Apache poi OOXML</b> library.
     * </p>
     * <p>
     *     The method uses {@link #initTable(Set, XSSFSheet)} method to init table in a sheet.
     * </p>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi">apache poi</a>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml">apache poi ooxml</a>
     */
    private void initTable(Set<String> sorters,XSSFSheet sheet){
        int rowNum = 0;
        int colNum = 0;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(colNum);
        cell.setCellValue(TABLE_HEADER);
        sheet.autoSizeColumn(colNum);
        for(String sorter:sorters){
            cell = row.createCell(++colNum);
            cell.setCellValue(sorter);
        }
    }
    /**
     * <p>
     *     Method used to draw charts in Excel file's using data from sheets.
     * </p>
     * <p>
     *     Uses <b>Apache Poi</b> and <b>Apache poi OOXML</b> library.
     * </p>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi">apache poi</a>
     * @see <a href="https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml">apache poi ooxml</a>
     */
    private void drawChart(XSSFSheet  sheet, int colNum,int rowNum){
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

        XSSFChart chart = drawing.createChart(anchor);
        chart.setTitleText("Sorter durations");
        chart.setTitleOverlay(false);
        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT);

        XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        bottomAxis.setTitle("Lengths");
        XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
        leftAxis.setTitle("Sorter durations");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        XDDFChartData data = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
        XDDFDataSource<Double> lengths = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                new CellRangeAddress(FIRST_LENGTH_ROW, rowNum, FIRST_LENGTH_COL, LAST_LENGTH_COL));

        for(int column=1;column<=colNum;column++){
            XDDFNumericalDataSource<Double> durations = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(FIRST_DURATION_ROW, rowNum, column, column));

            XDDFChartData.Series series = data.addSeries(lengths, durations);

            XDDFDataSource<String> sorters = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                    new CellRangeAddress(SORTERS_ROW, SORTERS_ROW, FIRST_LENGTH_COL, colNum));
            series.setTitle(sorters.getPointAt(column), null);
        }
        chart.plot(data);
    }
}
