package fillers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Vlad Ivashchenko
 *
 * <p>
 *     Annotation that used to mark {@link ArrayGenerator} class static methods
 *     so that {@link analyzer.Analyzer#analyze()} could find them and use.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Filler{

}
