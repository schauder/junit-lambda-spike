package de.schauderhaft.junit.main;

import de.schauderhaft.junit.core.ConsoleReporter;
import de.schauderhaft.junit.core.ExceptionFailure;
import de.schauderhaft.junit.core.Reporter;
import de.schauderhaft.junit.core.Test;
import de.schauderhaft.junit.core.TestSource;
import de.schauderhaft.junit.lambda.FixedClassTestSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class JUnitMain {
    private List<Test> tests = new ArrayList<>();

    public static void main(String[] args) {
        new JUnitMain().run();

    }

    private void run() {
        // find all Reporter, slightly simplified
        Reporter reporter = new ConsoleReporter();


        // find all test sources, slightly simplified
        List<TestSource> sources = asList(new FixedClassTestSource("de.schauderhaft.junit.example.ExampleTest"));

        // gather all Tests
        for (TestSource source : sources) {
            tests.addAll(source.gatherTests());
        }

        // execute all Tests
        for (Test test : tests) {
            reporter.before(test);
            final Optional<ExceptionFailure> result = test.execute();
            reporter.result(result);
        }


    }
}
