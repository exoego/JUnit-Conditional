package net.exoego.junit.ext.rule;

import net.exoego.junit.ext.annotation.RunIf;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunIfRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        RunIf annotation = description.getAnnotation(RunIf.class);
        if (annotation == null && description.getTestClass() != null) {
            annotation = description.getTestClass().getAnnotation(RunIf.class);
        }
        if (annotation != null) {
            if (!annotation.value()) {
                return new UnexpectedStatement("condition not satisfied");
            }
        }
        return base;
    }
}
