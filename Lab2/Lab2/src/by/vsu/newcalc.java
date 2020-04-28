package by.vsu;

import java.util.Vector;
import java.util.Scanner;

public class newcalc {
	public static Vector<Integer> func(int N) {
		Vector<Integer> arr = new Vector<Integer>();
		int[] a = new int[N + 1];
		a[1] = 0;		
		
		int min;
		for(int i = 2; i < N + 1; i++){
			min = a[i - 1] + 1;
			if(i%2 == 0) 
				{
				min = Math.min(min,a[i/2] + 1);
				}
			if(i%3 == 0) 
			{
				min = Math.min(min,a[i/3] + 1);
			}
			a[i] = min;
		}
		int i=N;
		while(i>1){
			if(a[i] == a[i -1] + 1){
				arr.add(0, 1);
				i--;
				continue;
			}
						
			if(i%2 == 0 && a[i] == a[i/2] + 1){
				arr.add(0, 2);
				i = i / 2;
				continue;
			}
						
			arr.add(0, 3);
			i = i /3;
		}
		arr.add(0, 1);
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		System.out.print("Введите целое число: ");
        if(sc.hasNextInt()) {
          N = sc.nextInt();
        } else {
          System.out.println("Вы ввели не целое число");
        }
		if (N>0) {
			System.out.println("N="+N);
			
			Vector<Integer> resultarr = new Vector<Integer>();
			resultarr = func(N);
			System.out.println("Последовательность кнопок: ");
	        System.out.println(resultarr);
		}
		else System.out.println("N<=0");
	
		
	}

}
