package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIf;
import net.exoego.junit.ext.annotation.RunIfOs;
import net.exoego.junit.ext.rule.RunIfOsRule;
import net.exoego.junit.ext.rule.RunIfRule;
import org.junit.Rule;
import org.junit.Test;
import static net.exoego.junit.ext.annotation.RunIfOs.*;

@RunIf(true)
public class IgnoringClassAndMethodTest {
    @Rule
    public RunIfRule runIfRule = new RunIfRule();
    @Rule
    public RunIfOsRule rule = new RunIfOsRule();

    @Test
    @RunIfOs(MAC)
    public void shouldRunOnMac() throws Exception {
    }

    @Test
    @RunIfOs(WINDOWS)
    public void shouldRunOnWindows() throws Exception {

    }

    @Test
    @RunIfOs(LINUX)
    public void shouldRunOnLinux() throws Exception {
    }
}