package by.vsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class DobleCompatatorTest {

    @Test
    public void compare() {
        Double a=12.5333645;
        Double b=12.5333644;
        DobleCompatator c =new DobleCompatator();
        assertEquals(1,c.compare(a,b));
    }
}
