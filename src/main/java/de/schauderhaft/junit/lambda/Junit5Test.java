package de.schauderhaft.junit.lambda;

import de.schauderhaft.junit.core.ExceptionFailure;
import de.schauderhaft.junit.core.Test;

import java.util.Optional;

/**
 * is basically a named function that can be executed and produces either nothing or some failure information
 */
public class Junit5Test implements Test {
    private final String name;
    private final Runnable testblock;

    public Junit5Test(String name, Runnable testblock) {

        this.name = name;
        this.testblock = testblock;
    }

    public Optional<ExceptionFailure> execute() {
        try {
            testblock.run();
        } catch (Exception ex) {
            return Optional.of(new ExceptionFailure(ex)) ;
        }
        return Optional.empty();
    }

    @Override
    public String name() {
        return name;
    }
}
