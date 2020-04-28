package by.vsu;

import java.util.Vector;
import java.util.Scanner;

public class calc {
	public static Vector<Integer> func(int N) {
		Vector<Integer> arr = new Vector<Integer>();
		while (N>0) {
			//System.out.print(N+"\n");
			while (N>0) {
				if(N % 3 == 0){
					//System.out.print("Делится на три."+"\n");
					N = N / 3;
					arr.add(0,3);
				}else break;
			}
			while (N>0) {
				if(N % 2 == 0){
					//System.out.print("Делится на два."+"\n");
					N = N / 2;
					arr.add(0,2);
				} else break;	
			}
		
			//System.out.print("Отнимаем 1 "+"\n");
			arr.add(0,1);
			N--;
		}
		return arr;
	}
	public static Vector<Integer> func1(int N) {
		Vector<Integer> arr1 = new Vector<Integer>();
		int n ;
		n = N - 1;
		if ((n % 3 != 0) && (n % 2 != 0)) {
			int i = 0;
			while(i <= n) {
				arr1.add(i);
				n--;
			}
		}
		if (n % 3 == 0) {
			while (n>0) {
				if(n % 3 != 0) {
					int i = 0;
					while(i <= n) {
						arr1.add(i);
						n--;
					}
					break;
					
				} else {
					n = n /3;
					arr1.add(0,3);
					if (n == 1) {
						break;
					}
				}
				
			}
		} 
		if (n % 2 == 0) {
			while (n>0) {
				if(n % 2 != 0) {
					int i = 0;
					while(i <= n) {
						arr1.add(i);
						n--;
					}
					break;
					
				} else {
					n = n /2;
					arr1.add(0,2);
					if (n == 1) {
						break;
					}
				}
				
			}
		} 
		arr1.add(1);
		arr1.add(0,1);
		return arr1;
	}
	public static Vector<Integer> func2(int N) {
		Vector<Integer> arr1 = new Vector<Integer>();
		int n ;
		n = N - 2;
		if ((n % 3 != 0) && (n % 2 != 0)) {
			int i = 0;
			while(i <= n) {
				arr1.add(i);
				n--;
			}
		}
		if (n % 3 == 0) {
			while (n>0) {
				if(n % 3 != 0) {
					int i = 0;
					while(i <= n) {
						arr1.add(i);
						n--;
					}
					break;
					
				} else {
					n = n /3;
					arr1.add(0,3);
					if (n == 1) {
						break;
					}
				}
				
			}
		} 
		if (n % 2 == 0) {
			while (n>0) {
				if(n % 2 != 0) {
					int i = 0;
					while(i <= n) {
						arr1.add(i);
						n--;
					}
					break;
					
				} else {
					n = n /2;
					arr1.add(0,2);
					if (n == 1) {
						break;
					}
				}
				
			}
		} 
		arr1.add(1);
		arr1.add(1);
		arr1.add(0,1);
		return arr1;
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
			Vector<Integer> arra = new Vector<Integer>();
			Vector<Integer> arrb = new Vector<Integer>();
			Vector<Integer> arrc = new Vector<Integer>();
			Vector<Integer> resultarr = new Vector<Integer>();
			arra = func(N);
			arrb = func1(N);
			arrc = func2(N);
			
			if (arra.size()<arrb.size() && arra.size()<arrc.size()) {
				resultarr = arra;
			}
			if (arrb.size()<arra.size() && arrb.size()<arrc.size()) {
				resultarr = arrb;
			}
			if (arrc.size()<arra.size() && arrc.size()<arrb.size()) {
				resultarr = arrc;
			}
			/*
			System.out.println(arra.size() + " " + arrb.size());
			System.out.println(arra);
			System.out.println(arrb);
			System.out.println(arrc);
			*/
			System.out.println("Последовательность кнопок: ");
	        System.out.println(resultarr);
		}
		else System.out.println("N<=0");
	
		
	}

}
