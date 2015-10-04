package de.schauderhaft.junit.lambda;

import de.schauderhaft.junit.core.Test;
import de.schauderhaft.junit.core.TestSource;

import java.util.ArrayList;
import java.util.List;

public class FixedClassTestSource implements TestSource {
    private static List<Test> tests = new ArrayList<>();
    private final String className;

    public FixedClassTestSource(String className) {
        this.className = className;
    }

    @Override
    public List<Test> gatherTests() {
        try {
            Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tests;
    }


    static void register(Test test) {
        tests.add(test);
    }
}
