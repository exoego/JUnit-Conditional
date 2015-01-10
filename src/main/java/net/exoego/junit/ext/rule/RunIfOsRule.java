package net.exoego.junit.ext.rule;

import net.exoego.junit.ext.annotation.RunIfOs;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunIfOsRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        RunIfOs annotation = description.getAnnotation(RunIfOs.class);
        if (annotation == null && description.getTestClass() != null) {
            annotation = description.getTestClass().getAnnotation(RunIfOs.class);
        }
        if (annotation != null) {
            final String expected = annotation.value();
            final String actual = System.getProperty("os.name");
            final boolean osSatisfied = actual.toLowerCase().contains(expected);
            if (!osSatisfied) {
                final String format = String.format("Required OS is %s but %s", expected, actual);
                return new UnexpectedStatement(format);
            }
        }
        return base;
    }
}
