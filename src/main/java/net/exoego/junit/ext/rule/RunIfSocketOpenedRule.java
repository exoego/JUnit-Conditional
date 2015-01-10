package net.exoego.junit.ext.rule;

import net.exoego.junit.ext.annotation.RunIfSocketOpened;
import net.exoego.junit.ext.checker.SocketChecker;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunIfSocketOpenedRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        RunIfSocketOpened annotation = description.getAnnotation(RunIfSocketOpened.class);
        if (annotation == null && description.getTestClass() != null) {
            annotation = description.getTestClass().getAnnotation(RunIfSocketOpened.class);
        }
        if (annotation != null) {
            final String host = annotation.host();
            final int port = annotation.port();
            final int timeout = annotation.timeoutMilliseconds();
            final boolean socketIsOpen = new SocketChecker(host, port, timeout).satisfy();
            if (!socketIsOpen) {
                final String msg = String.format("%s:%s can not be open.", host, port);
                return new UnexpectedStatement(msg);
            }
        }
        return base;
    }
}
