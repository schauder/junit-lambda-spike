package de.schauderhaft.junit.core;

import java.util.Optional;

public interface Test {
    Optional<ExceptionFailure> execute();

    String name();
}
