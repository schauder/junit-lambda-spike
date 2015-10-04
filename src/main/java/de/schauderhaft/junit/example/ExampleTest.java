package de.schauderhaft.junit.example;


import de.schauderhaft.junit.lambda.TestFactory;

public class ExampleTest {
    {
        TestFactory.test("The very first Test", () -> {

            System.out.println("this is a test that does nothing, except running");

        });
    }
}
