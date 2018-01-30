package com.johnoct.projects.shoppingbasket;

    import org.junit.runner.JUnitCore;
    import org.junit.runner.Result;
    import org.junit.runner.notification.Failure;

/**
 * @author John Octubre
 * @date 2018-01-29
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ShoppingBasketTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}

