package net.exoego.junit.ext.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Indicate that the annotated test itself or tests under the annotated class should be skipped
 * whenever Socket can not be open against the given host and port.
 */
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = {METHOD, TYPE})
public @interface RunIfSocketOpened {
    String host();

    int port() default 80;
    int timeoutMilliseconds() default 5000;
}
