package by.vsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringLengthCompatatorTest {

    @Test
    public void Test1() {
        String s1="abcde";
        String s2="abcd";
        StringLengthCompatator c = new StringLengthCompatator();
        assertEquals(c.compare(s1,s2),1);
    }
    @Test
    public void Test2() {
        String s2="abcde";
        String s1="abcd";
        StringLengthCompatator c = new StringLengthCompatator();
        assertEquals(c.compare(s1,s2),-1);
    }
    @Test
    public void Test3() {
        String s2="abcd";
        String s1="abcd";
        StringLengthCompatator c = new StringLengthCompatator();
        assertEquals(c.compare(s1,s2),0);
    }
}
