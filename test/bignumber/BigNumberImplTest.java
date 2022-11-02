package bignumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigNumberImplTest {
    private BigNumber num;

    @Before
    public void setup() {
        num = new BigNumberImpl();
        num.shiftLeft(1);
        num.addDigit(5);
    }

    @Test
    public void testCopyConstructor() {
        BigNumber otherNum = new BigNumberImpl("5");
        assertEquals(num.toString(), otherNum.toString());
    }
    @Test
    public void length() {
        assertEquals(1, num.length());
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