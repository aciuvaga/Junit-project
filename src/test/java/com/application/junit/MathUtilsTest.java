package com.application.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up..");
    }

    @RepeatedTest(3)
    @DisplayName("Testing computeCircleArea method")
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right Circle Area");
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing divide method")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw ArithmeticException");
    }

    @Test
    @Disabled
    @DisplayName("TDD method shoud not run")
    void testDisabled() {
        fail();
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(-2, 1))
        );
    }

    @Nested
    @Tag("Math")
    class AddTest {

        @Test
        @DisplayName("Testing add method positive")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "The add method should add to number");
        }

        @Test
        @DisplayName("Testing add method negative")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
        }
    }
}