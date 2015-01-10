package net.exoego.junit.ext.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Indicate that the annotated test itself or tests under the annotated class should be skipped
 * whenever the given value is false.
 */
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = {METHOD, TYPE})
public @interface RunIf {
    boolean value();
}
