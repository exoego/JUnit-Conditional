package net.exoego.junit;

import net.exoego.junit.donotinvokedirectly.IgnoringClassAndMethodTest;
import net.exoego.junit.donotinvokedirectly.IgnoringClassTest;
import net.exoego.junit.donotinvokedirectly.IgnoringMethodTest;
import net.exoego.junit.donotinvokedirectly.DifferentOSTest;
import net.exoego.junit.donotinvokedirectly.RunIfSocketOpenedTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import net.exoego.junit.donotinvokedirectly.RunIfURLReachableTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.Failure;
import org.junit.runners.BlockJUnit4ClassRunner;

public class AllTest {
    private TestCountListener countListener;
    private RunNotifier runNotifier;
    private TestResultListener testResultListener;

    @Before
    public void setUp() {
        runNotifier = new RunNotifier();
        countListener = new TestCountListener();
        testResultListener = new TestResultListener();
        runNotifier.addListener(countListener);
        runNotifier.addListener(testResultListener);
    }

    @Test
    public void shouldNotRunAnyMethod() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(IgnoringMethodTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(1));
        assertThat(countListener.ignored(), is(1));
        assertThat(testResultListener.isPassed(), is(true));
    }

    @Test
    public void shouldOnlyRunTestCaseAssociatedWithOS() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(DifferentOSTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(3));
        assertThat(countListener.ignored(), is(2));
        assertThat(testResultListener.isPassed(), is(true));
    }

    @Test
    public void shouldOnlyIgnoreAllTestCases() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(IgnoringClassTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(3));
        assertThat(countListener.ignored(), is(3));
        assertThat(testResultListener.isPassed(), is(true));
    }

    @Test
    public void shouldOnlyRunTestCasesWhenClassIsNotIgnored() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(IgnoringClassAndMethodTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(3));
        assertThat(countListener.ignored(), is(2));
        assertThat(testResultListener.isPassed(), is(true));
    }

    @Test
    public void shouldOnlyRunTestCasesWhenSocketOpen() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(RunIfSocketOpenedTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(2));
        assertThat(countListener.ignored(), is(1));
        assertThat(testResultListener.isPassed(), is(true));
    }

    @Test
    public void shouldOnlyRunTestCasesWhenURLIsReachleable() throws Exception {
        BlockJUnit4ClassRunner awareClassRunner = new BlockJUnit4ClassRunner(RunIfURLReachableTest.class);
        awareClassRunner.run(runNotifier);
        assertThat(countListener.all(), is(2));
        assertThat(countListener.ignored(), is(1));
        assertThat(testResultListener.isPassed(), is(true));
    }

    private class TestCountListener extends RunListener {
        private int countTotal = 0;
        private int countIgnored = 0;

        public int all() {
            return countTotal;
        }

        public int ignored() {
            return countIgnored;
        }

        @Override
        public void testFinished(Description description) throws Exception {
            countTotal++;
        }

        @Override
        public void testAssumptionFailure(Failure failure) {
            countIgnored++;
        }
    }

    private class TestResultListener extends RunListener {
        private boolean failed = false;

        public boolean isPassed() {
            return !failed;
        }

        public void testFailure(Failure failure) throws Exception {
            failed = true;
        }
    }
}
