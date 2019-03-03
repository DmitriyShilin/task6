package formatstring;

import formatstring.exception.LargeNumberValueException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class FormatStringTest {
    
    public FormatStringTest() {
    }

    @Test
    public void testGetList() {
        int number = 123;
        FormatString instance = new FormatString(1, 1);
        LinkedList<Integer> expResult = new LinkedList<>();
        expResult.add(3);
        expResult.add(2);
        expResult.add(1);
        LinkedList<Integer> result = instance.getList(number);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnderLine() {
        int size = 1;
        FormatString instance = new FormatString(1, 1);
        String expResult = "_";
        String result = instance.underLine(size);
        assertEquals(expResult, result);
    }

    @Test(expected = LargeNumberValueException.class)
    public void testMultiply() throws Exception {
        FormatString instance = new FormatString(132131313, 1313131313);
        instance.multiply();
    }

    @Test
    public void testCreateFormatDecimal() {
        int indent = 10;
        FormatString instance = new FormatString(1, 1);
        String expResult = "%10d";
        String result = instance.createFormatDecimal(indent);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateFormatString() {
        int indent = 10;
        FormatString instance = new FormatString(1, 1);
        String expResult = "%10s";
        String result = instance.createFormatString(indent);
        assertEquals(expResult, result);
    }
    
}
