package net.exoego.junit.checker;

import static net.exoego.junit.TestUtil.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import net.exoego.junit.ext.checker.SocketChecker;
import org.junit.Test;

public class SocketCheckerTest {
    @Test
    public void shouldReturnTrueWhenResourceIsReachable() {
        long start = System.currentTimeMillis();
        SocketChecker checker = new SocketChecker("167.18.7.51", 8153);
        long end = System.currentTimeMillis();
        assertThat(checker.satisfy(), is(false));
        assertThat(end - start, is(lessThan(10000L)));
    }
}