package net.exoego.junit.checker;

import static net.exoego.junit.TestUtil.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import net.exoego.junit.ext.checker.URLChecker;
import org.junit.Test;

public class HttpCheckerTest {
    @Test
    public void shouldReturnTrueWhenResourceIsReachable() {
        URLChecker httpChecker = new URLChecker("http://www.google.com");
        assertThat(httpChecker.satisfy(), is(true));
    }

    @Test
    public void shouldReturnFalseWhenResourceIsNotReachable() {
        URLChecker httpChecker = new URLChecker("http://www.somewhere.not/exist");
        assertThat(httpChecker.satisfy(), is(false));
    }

    @Test
    public void shouldReturnFalseWhenDefaultTimeout() {
        long start = System.currentTimeMillis();
        URLChecker httpChecker = new URLChecker("http://zzzz.example.com");
        long end = System.currentTimeMillis();
        assertThat(httpChecker.satisfy(), is(false));
        assertThat(end - start, is(lessThan(10000L)));
    }

    @Test
    public void shouldReturnFalseWhenTimeoutSpecified() {
        long start = System.currentTimeMillis();
        final int timeoutMilliseconds = 3000;
        URLChecker httpChecker = new URLChecker("http://zzzz.example.com", timeoutMilliseconds);
        long end = System.currentTimeMillis();
        assertThat(httpChecker.satisfy(), is(false));
        assertThat(end - start, is(lessThan((long) timeoutMilliseconds)));
    }
}
