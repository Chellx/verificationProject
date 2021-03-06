
package test.java;
import main.java.*;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.util.ArrayList;


public class BolgerMichelleTestTask1 {

    Rate rate;
    ArrayList<Period> reducedPeriods;
    ArrayList<Period> normalPeriods;
    VisitorReduction visitor = new VisitorReduction();
    StaffReduction staff = new StaffReduction();
    StudentReduction student = new StudentReduction();
    ManagementReduction management = new ManagementReduction();

    //TestCase 1
    @Test
    @DisplayName("normalRate < 0  return IllegalArgumentException")
    void testCase1(){

        Period periodStay = new Period(9,12);

        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(2);

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("A rate cannot be negative", exception.getMessage());
    }
    //TestCase 2
    @Test
    @DisplayName("reducedRate < 0 return IllegalArgumentException")
    void testCase2(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-1);

        Period periodStay = new Period(9,12);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(student,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("A rate cannot be negative", exception.getMessage());
    }

    //TestCase 3
    @Test
    @DisplayName("reducedRate > normalRate return IllegalArgumentException")
    void testCase3(){


        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(10);

        Period periodStay = new Period(9,12);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(management,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The normal rate cannot be less or equal to the reduced rate", exception.getMessage());
    }

    //TestCase 4
    @Test
    @DisplayName("reducePeriod & normalPeriod overlap return IllegalArgumentException")
    void testCase4(){


        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,11));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);


        Period periodStay = new Period(9,12);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods overlaps", exception.getMessage());
    }

    //TestCase 5
    @Test
    @DisplayName("reducePeriods overlap return IllegalArgumentException")
    void testCase5(){

        Period periodStay = new Period(9,12);

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(7,10));
            add(1,new Period(8,12));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods are not valid individually", exception.getMessage());
    }
    //TestCase 6
    @Test
    @DisplayName("Two reducePeriod collections overlap return IllegalArgumentException")
    void testCase6(){



        Period periodStay = new Period(9,12);


        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,12));
            add(1,new Period(7,10));
            add(2,new Period(8,11));
            add(3,new Period(9,12));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);



        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods are not valid individually", exception.getMessage());
    }

    //TestCase 7
    @Test
    @DisplayName("normalPeriods overlap return IllegalArgumentException")
    void testCase7(){

        Period periodStay = new Period(9,12);

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(20,22));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(7,10));
            add(1,new Period(8,12));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(management,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods are not valid individually", exception.getMessage());
    }
    //TestCase 8
    @Test
    @DisplayName("Two normalPeriod collections overlap return IllegalArgumentException")
    void testCase8(){

        Period periodStay = new Period(9,12);

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(20,22));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,12));
            add(1,new Period(7,10));
            add(2,new Period(8,11));
            add(3,new Period(9,12));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods are not valid individually", exception.getMessage());
    }


    //TestCase 9
    @Test
    @DisplayName("normalRate && reduceRate = 0 Return 0")
    void testCase9(){
        Period periodStay = new Period(9,12);

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(20,22));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};


        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(0);

        rate = new Rate(student,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(0);
        Assertions.assertEquals(expected,rate.calculate(periodStay));
    }

    //TestCase 10
    @Test
    @DisplayName("periodStay in reducePeriod Return 4")
    void testCase10(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(5,7);
        rate = new Rate(management,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(4);
        Assertions.assertEquals(expected,rate.calculate(periodStay));
    }

    //TestCase 11
    @Test
    @DisplayName("periodStay in normalPeriod Return 15")
    void testCase11(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(10,13);
        rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(2.5);
        Assertions.assertEquals(expected,rate.calculate(periodStay));
    }

    //TestCase 12
    @Test
    @DisplayName("periodStay begin in freePeriod ends in normalPeriod RETURN 30")
    void testCase12(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(20,22));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(6,15);
        rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(16);
        Assertions.assertEquals(expected,rate.calculate(periodStay));
    }

    //TestCase 13
    @Test
    @DisplayName("periodStay begin in freePeriod ends in reducedPeriod RETURN 6")
    void testCase13(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(5,8));
        }};
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);


        Period periodStay = new Period(3,8);
        rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(6);
        Assertions.assertEquals(expected,rate.calculate(periodStay));
    }

    //TestCase 14
    @Test
    @DisplayName("reducedPeriod returns NULL")
    void testCase14(){

        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(3,8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(staff,normalRate,reducedRate,null,normalPeriods));
        Assertions.assertEquals("periods cannot be null", exception.getMessage());
    }

    //TestCase 15
    @Test
    @DisplayName("normalPeriod returns NULL")
    void testCase15(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,17));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(3,8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,null));
        Assertions.assertEquals("periods cannot be null", exception.getMessage());

    }

    //TestCase 16
    @Test
    @DisplayName("reducedRate returns NULL")
    void testCase16(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,17));
        }};

        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(6,9));
        }};

        BigDecimal normalRate = new BigDecimal(5);

        Period periodStay = new Period(3,8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(student,normalRate,null,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The rates cannot be null", exception.getMessage());

    }

    //TestCase 17
    @Test
    @DisplayName("normalRate returns NULL")
    void testCase17(){

        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,17));
        }};

        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(6,9));
        }};


        BigDecimal reducedRate = new BigDecimal(2);

        Period periodStay = new Period(3,8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(management,null,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The rates cannot be null", exception.getMessage());

    }
    //TestCase 18
    @Test
    @DisplayName("first normalPeriod overlaps first reducedPeriod")
    void testCase18(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(17,20));
            add(1,new Period(4,9));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(18,19));
            add(1,new Period(12,13));
        }};

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods));
        Assertions.assertEquals("The periods overlaps", exception.getMessage());
    }

    @Test
    @DisplayName("Check if staff amount is above 16")
    void staffReductionAboveSixteen(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(staff,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(14);
        BigDecimal result =  rate.calculate(new Period(9,14));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if staff amount is below 16")
    void staffReductionBelowSixteen(){

        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(staff,new BigDecimal(5),new BigDecimal(3),reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(9);
        BigDecimal result =  rate.calculate(new Period(10,13));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if student reduction is above 5.50")
    void studentReductionBelowFiveFifty(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(student,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(6.375);
        BigDecimal result =  rate.calculate(new Period(10,13));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if student reduction is 5.50")
    void studentReductionIsFiveFifty(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5.50);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(student,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(5.50);
        BigDecimal result =  rate.calculate(new Period(8,9));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if management minimum payable is 4.00")
    void managementReductionIfFour(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(management,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(4);
        BigDecimal result =  rate.calculate(new Period(11,12));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if management minimum payable is over 4.00")
    void managementReductionIfOverFour(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(8,10));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(10,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(management,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(11);
        BigDecimal result =  rate.calculate(new Period(9,12));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if Visitor reduction is over 10")
    void visitorReductionIsOverTen(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,11));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(11,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(3);
        BigDecimal result =  rate.calculate(new Period(9,13));
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("Check if Visitor reduction is under 10")
    void visitorReductionIsUnderTen(){
        normalPeriods = new ArrayList<Period>() {{
            add(0,new Period(9,11));
        }};
        reducedPeriods = new ArrayList<Period>() {{
            add(0,new Period(11,13));
        }};
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        rate = new Rate(visitor,normalRate,reducedRate,reducedPeriods,normalPeriods);
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result =  rate.calculate(new Period(9,10));
        Assertions.assertEquals(expected,result);
    }
}
