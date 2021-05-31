package io.learn;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;


class MathUtilTest {
    MathUtils mathUtils;
    TestReporter tr;

    @BeforeEach
    void init(TestReporter testReporter)
    {
        tr=testReporter;
       mathUtils = new MathUtils();
    }

    @Test
    @Tag("Math")
    @EnabledOnOs(OS.MAC)
    @DisplayName("Adding two numbers ,run only for mac")
    void testAdd()
    {

        tr.publishEntry("This is a  add method");

        int response=mathUtils.add(4,5);
        assertEquals(9,response,"Message:Add method should give sum of two numbers");
        assertEquals(9,mathUtils.add(3,6),"Message:Add method should give sum of two numbers");
        assertEquals(9,mathUtils.add(2,7),"Message:Add method should give sum of two numbers");
        assertEquals(9,mathUtils.add(2,7),"Message:Add method should give sum of two numbers");
    }

    @Test
    @Tag("Math")
    @DisplayName("Add to number AssertAll")
    void testMultiAssertAdd()
    {
        tr.publishEntry("This is a  testMultiAssertAdd");
        assertAll(()->assertEquals(9,mathUtils.add(3,6)),
                ()->assertEquals(9,mathUtils.add(2,7)),
                ()->assertEquals(9,mathUtils.add(9,0))
                );
    }


    @DisplayName("Compute circle area")
    @RepeatedTest(4)
    @Tag("Circle")
    void testComputeCircleArea(RepetitionInfo ri)
    {
        tr.publishEntry("Compute_Circle_Area");
        //System.out.println("current: "+ri.getCurrentRepetition());
        //System.out.println("total repetition: "+ri.getTotalRepetitions());
        double response=mathUtils.computeCircleArea(10);
        double expected=314;
        assertEquals(expected,response,()->"Message:This method should calculate area of circle :"+expected+" .");
    }

    @Test
    @DisplayName("Divide number")
    void testDivide()
    {
        tr.publishEntry("divide method");
        assertThrows(ArithmeticException.class,()->mathUtils.divide(1,0),"throws error ArithmeticException for divide ");
    }

    @Test
    @Disabled("Work under progress")
    @DisplayName("Test under progress")
    void testMultiply()
    {
        assertEquals(5,mathUtils.multiply(2,2));
    }
}
