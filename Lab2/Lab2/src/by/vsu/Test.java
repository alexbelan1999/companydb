package by.vsu;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test1() {
		triangle test = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(5.0,1.0);
		boolean result =test.func(A, B, C, point);
		assertEquals(true, result);
		
	}
	@org.junit.Test
	public void test2() {
		triangle junit = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(3.0,0.0);
		boolean result = junit.func(A, B, C, point);
		assertEquals(true, result);
	}
	@org.junit.Test
	public void test3() {
		triangle junit = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(3.0,3.0);
		boolean result = junit.func(A, B, C, point);
		assertEquals(true, result);
	}
	@org.junit.Test
	public void test4() {
		triangle junit = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(6.0,3.0);
		boolean result = junit.func(A, B, C, point);
		assertEquals(true, result);
	}
	@org.junit.Test
	public void test5() {
		triangle junit = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(-10.0,-10.0);
		boolean result = junit.func(A, B, C, point);
		assertEquals(false, result);
	}
	@org.junit.Test
	public void test6() {
		triangle junit = new triangle();
		Point A = new Point(0.0, 0.0);
		Point B = new Point(6.0, 0.0);
		Point C = new Point(6.0, 6.0);
		Point point = new Point(-3.5, 10.0);
		boolean result = junit.func(A, B, C, point);
		assertEquals(false, result);
	}
}
