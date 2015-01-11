package net.exoego.junit.donotinvokedirectly;

import net.exoego.junit.ext.annotation.RunIfOs;
import net.exoego.junit.ext.rule.RunIfOsRule;
import org.junit.Rule;
import org.junit.Test;

import static net.exoego.junit.ext.annotation.RunIfOs.*;

public class DifferentOSTest {
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
