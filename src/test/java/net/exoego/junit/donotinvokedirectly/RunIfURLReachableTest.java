package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIfURLReachable;
import net.exoego.junit.ext.rule.RunIfSocketOpenedRule;
import net.exoego.junit.ext.rule.RunIfURLReachableRule;
import org.junit.Rule;
import org.junit.Test;

public class RunIfURLReachableTest {
    @Rule
    public RunIfURLReachableRule rule = new RunIfURLReachableRule();

    @Test
    @RunIfURLReachable("http://www.google.com")
    public void shouldRun() throws Exception {
    }

    @Test
    @RunIfURLReachable("http://www.somewhereinthere.notexist")
    public void shouldNotRun() throws Exception {
    }
}
