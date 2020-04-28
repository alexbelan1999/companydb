package by.vsu;

import static org.junit.Assert.*;

import java.util.Vector;

public class Calctest {

	@org.junit.Test
	public void test1() {
		int N = 11;
		Vector<Integer> arra = new Vector<Integer>();
		Vector<Integer> arrb = new Vector<Integer>();
		arra.add(1);
		arra.add(1);
		arra.add(2);
		arra.add(1);
		arra.add(2);
		arra.add(1);
		arrb = calc.func(N);
		boolean result = arra.equals(arrb);
		System.out.println(result);
		assertEquals(true, result);
		
	}
	@org.junit.Test
	public void test2() {
		int N = 10;
		Vector<Integer> arra = new Vector<Integer>();
		Vector<Integer> arrb = new Vector<Integer>();
		arra.add(1);
		arra.add(1);
		arra.add(2);
		arra.add(1);
		arra.add(2);
		arrb = calc.func(N);
		boolean result = arra.equals(arrb);
		assertEquals(true, result);
		
	}
	@org.junit.Test
	public void test3() {
		int N = 0;
		Vector<Integer> arra = new Vector<Integer>();
		Vector<Integer> arrb = new Vector<Integer>();
		arra.add(1);
		arra.add(1);
		arra.add(2);
		arra.add(1);
		arra.add(2);
		arrb = calc.func(N);
		boolean result = arra.equals(arrb);
		assertEquals(false, result);
		
	}
	@org.junit.Test
	public void test4() {
		int N = -8;
		Vector<Integer> arra = new Vector<Integer>();
		Vector<Integer> arrb = new Vector<Integer>();
		arra.add(1);
		arra.add(1);
		arra.add(2);
		arra.add(1);
		arra.add(2);
		arrb = calc.func(N);
		boolean result = arra.equals(arrb);
		assertEquals(false, result);
		
	}
}
