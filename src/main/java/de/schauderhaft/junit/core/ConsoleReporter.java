package de.schauderhaft.junit.core;

import java.util.Optional;

public class ConsoleReporter implements Reporter {
    @Override
    public void before(Test test) {
        System.out.println("starting test " + test.name());
    }

    @Override
    public void result(Optional<ExceptionFailure> result) {
        System.out.println("test result: " + result);
    }
}
