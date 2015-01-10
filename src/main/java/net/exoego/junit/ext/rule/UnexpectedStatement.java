package net.exoego.junit.ext.rule;

import org.junit.Assume;
import org.junit.runners.model.Statement;

final class UnexpectedStatement extends Statement {
    private final String message;

    UnexpectedStatement(final String message) {
        this.message = message;
    }

    @Override
    public void evaluate() {
        Assume.assumeTrue(message, false);
    }
}
