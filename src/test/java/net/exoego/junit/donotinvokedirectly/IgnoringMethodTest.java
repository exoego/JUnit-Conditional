package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIf;
import net.exoego.junit.ext.rule.RunIfRule;
import org.junit.Rule;
import org.junit.Test;

public class IgnoringMethodTest {
    @Rule
    public RunIfRule rule = new RunIfRule();

    @Test
    @RunIf(false)
    public void shouldNotRun() throws Exception {
    }
}
