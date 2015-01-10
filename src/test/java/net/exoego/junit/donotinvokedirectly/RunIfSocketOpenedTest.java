package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIfSocketOpened;
import net.exoego.junit.ext.rule.RunIfSocketOpenedRule;
import org.junit.Rule;
import org.junit.Test;

public class RunIfSocketOpenedTest {
    @Rule
    public RunIfSocketOpenedRule rule = new RunIfSocketOpenedRule();

    @Test
    @RunIfSocketOpened(host = "www.google.com", port = 80)
    public void shouldRun() throws Exception {
    }

    @Test
    @RunIfSocketOpened(host = "www.somewhereinthere.not", port = 80)
    public void shouldNotRun() throws Exception {
    }
}
