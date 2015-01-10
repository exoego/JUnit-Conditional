package net.exoego.junit.ext.rule;

import net.exoego.junit.ext.annotation.RunIfURLReachable;
import net.exoego.junit.ext.checker.URLChecker;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunIfURLReachableRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        RunIfURLReachable annotation = description.getAnnotation(RunIfURLReachable.class);
        if (annotation == null && description.getTestClass() != null) {
            annotation = description.getTestClass().getAnnotation(RunIfURLReachable.class);
        }
        if (annotation != null) {
            final String url = annotation.value();
            final int timeout = annotation.timeoutMilliseconds();
            final boolean isUrlReachable = new URLChecker(url, timeout).satisfy();
            if (!isUrlReachable) {
                final String msg = String.format("%s is not reachable", url);
                return new UnexpectedStatement(msg);
            }
        }
        return base;
    }
}
