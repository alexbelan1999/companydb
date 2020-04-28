package by.vsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringContanceCompatatorTest {

    @Test
    public void Test1() {
        String s1="aaa";
        String s2="a";
        StringContanceCompatator c = new StringContanceCompatator();
        assertEquals(c.compare(s1,s2),1);
    }
    @Test
    public void Test2() {
        String s2="aaa";
        String s1="a";
        StringContanceCompatator c = new StringContanceCompatator();
        assertEquals(c.compare(s1,s2),-1);
    }
    @Test
    public void Test3() {
        String s2="aa";
        String s1="aa";
        StringContanceCompatator c = new StringContanceCompatator();
        assertEquals(c.compare(s1,s2),0);
   }
}