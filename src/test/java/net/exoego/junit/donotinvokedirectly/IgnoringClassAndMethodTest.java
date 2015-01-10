package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIf;
import net.exoego.junit.ext.annotation.RunIfOs;
import net.exoego.junit.ext.rule.RunIfOsRule;
import net.exoego.junit.ext.rule.RunIfRule;
import org.junit.Rule;
import org.junit.Test;

@RunIf(true)
public class IgnoringClassAndMethodTest {
    @Rule
    public RunIfRule runIfRule = new RunIfRule();
    @Rule
    public RunIfOsRule rule = new RunIfOsRule();

    @Test
    @RunIfOs(RunIfOs.MAC)
    public void shouldRunOnMac() throws Exception {
    }

    @Test
    @RunIfOs(RunIfOs.WINDOWS)
    public void shouldRunOnWindows() throws Exception {

    }

    @Test
    @RunIfOs(RunIfOs.LINUX)
    public void shouldRunOnLinux() throws Exception {
    }
}