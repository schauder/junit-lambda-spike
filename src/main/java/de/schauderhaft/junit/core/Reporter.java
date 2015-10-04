package de.schauderhaft.junit.core;

import java.util.Optional;

public interface Reporter {
    void before(Test test);

    void result(Optional<ExceptionFailure> result);
}
