package de.schauderhaft.junit.lambda;

import static de.schauderhaft.junit.lambda.FixedClassTestSource.register;

public class TestFactory {
    public static void test(String name, Runnable testblock) {
        register(new Junit5Test(name, testblock));
    }
}
