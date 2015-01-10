package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIfOs;
import net.exoego.junit.ext.rule.RunIfOsRule;
import org.junit.Rule;
import org.junit.Test;

public class DifferentOSTest {
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
