package bignumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigNumberImplTest {
    private BigNumber num;
    private BigNumber num2;

    @Before
    public void setup() {
        num = new BigNumberImpl();
        num2 = new BigNumberImpl("11111");
        num.shiftLeft(1);
        num.addDigit(5);
    }

    @Test
    public void testCopyConstructor() {
        BigNumber otherNum = new BigNumberImpl("5234");
        BigNumber otherNum2 = new BigNumberImpl();
        otherNum2.shiftLeft(1);
        otherNum2.addDigit(5);
        otherNum2.shiftLeft(1);
        otherNum2.addDigit(2);
        otherNum2.shiftLeft(1);
        otherNum2.addDigit(3);
        otherNum2.shiftLeft(1);
        otherNum2.addDigit(4);
        System.out.println(otherNum.toString());
        assertEquals(otherNum.toString(), otherNum2.toString());
    }
    @Test
    public void length() {
        assertEquals(5, num2.length());
    }

    @Test
    public void shiftLeft() {
    }

    @Test
    public void shiftRight() {
    }

    @Test
    public void addDigit() {
    }

    @Test
    public void getDigitAt() {
        assertEquals(5, num.getDigitAt(0));
        num.shiftLeft(1);
        num.addDigit(2);
        System.out.println(num.toString());
        assertEquals(2, num.getDigitAt(0));
    }

    @Test
    public void copy() {
    }

    @Test
    public void add() {
    }

    @Test
    public void compareTo() {
    }

    @Test
    public void getIterator() {
    }

    @Test
    public void testToString() {
        assertEquals("5", num.toString());
    }
}