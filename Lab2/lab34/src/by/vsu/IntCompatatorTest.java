package by.vsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntCompatatorTest {

    @Test
    public void compare1() {
        Integer a=12;
        Integer b=6;
        IntCompatator c =new IntCompatator();
        assertEquals(1,c.compare(a,b));
    }
}
