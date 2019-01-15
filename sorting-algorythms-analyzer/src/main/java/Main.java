import output.Output;

import java.io.IOException;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Main class of program.
 *</p>
 */

public class Main {

    public static void main(String[] args) {
        Output output = new Output();
        try {
            output.writeToExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
