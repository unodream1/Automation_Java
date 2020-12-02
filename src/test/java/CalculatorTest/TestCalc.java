package CalculatorTest;


import Calculator.Calc;
import org.junit.Assert;
import org.junit.Test;

public class TestCalc {
    @Test
    public void testAdd(){
        Calc c = new Calc();
        Assert.assertEquals(5,c.add(2,3));
    }
    @Test
    public void testSub(){
        Calc c = new Calc();
        Assert.assertEquals(4,c.sub(8,4));
    }
    @Test
    public void testMultiply(){
        Calc c = new Calc();
        Assert.assertEquals(5,c.multiply(2,3));
    }
    @Test
    public void testDivide(){
        Calc c = new Calc();
        Assert.assertEquals(4,c.divide(8,2));
        //Assert.assertEquals(2.5,c.divide(5.0,2.0));
    }
}
