package by.vsu;

import java.util.Scanner;

public class Main {
	public static void main(String[] arstring) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������:");
		System.out.println("1) f(x) = (e^x) * (cos (x));");
		System.out.println("2) f(x) = (x^2 + 3 * x - 4)^(-1);");
		System.out.println("3) f(x) = ln(x^0.5);");
		System.out.println("�������� ������:");
		int funcnumber =  sc.nextInt();
		System.out.println();
		System.out.println("�������� ����� ����������");
		System.out.println("1) ������� ����� ��������������;");
		System.out.println("2) ������� ������ ���������������;");
		System.out.println("3) ������� ��������;");
		int formulanumber = sc.nextInt();
		System.out.println();
		System.out.println("������� ������ ������� ���������: ");
		double start = sc.nextDouble();
		System.out.println("������� ����� ������� ���������: ");
		double end = sc.nextDouble();
		if (start > end) {
			System.out.println("������! \r\n������� ������ � ����� �������:");
			start = sc.nextDouble();
			end = sc.nextDouble();
		}
		System.out.println();
		double h = (end-start)/1000;
		double result = 0;
		String answer = "�������� ������������� ��������� ��� �������  ";
		switch (funcnumber) {
		case 1:
			Function1 func1 = new Function1();
			answer = answer + "f(x) = (e^x) * (cos (x)) ";
			switch (formulanumber) {
			case 1:
				Formula1 form1 = new Formula1();
				answer = answer + "�� ������� ����� ���������������  ";
				result = form1.solve(result, h, start, func1);
				break;
			case 2:
				Formula2 form2 = new Formula2();
				answer = answer + "�� ������� ������ ���������������  ";
				result = form2.solve(result, h, start, func1);
				break;
			case 3:
				Formula3 form3 = new Formula3();
				answer = answer + "�� ������� ��������  ";
				result = form3.solve(result, h, start, func1);
				break;
			default:
				System.out.println("������ ������ ���!");
				break;
			}
			break;
		case 2:
			Function2 func2 = new Function2();
			answer = answer + "f(x) = (x^2 + 3 * x - 4)^(-1) ";
			switch (formulanumber) {
			case 1:
				Formula1 form1 = new Formula1();
				answer = answer + "�� ������� ����� ���������������  ";
				result = form1.solve(result, h, start, func2);
				break;
			case 2:
				Formula2 form2 = new Formula2();
				answer = answer + "�� ������� ������ ���������������  ";
				result = form2.solve(result, h, start, func2);
				break;
			case 3:
				Formula3 form3 = new Formula3();
				answer = answer + "�� ������� ��������  ";
				result = form3.solve(result, h, start, func2);
				break;
			default:
				System.out.println("������ ������ ���!");
				break;
			}
			break;
		case 3:
			Function3 func3 = new Function3();
			answer = answer + "f(x) = ln(x^0.5) ";
			switch (formulanumber) {
			case 1:
				Formula1 form1 = new Formula1();
				answer = answer + "�� ������� ����� ���������������  ";
				result = form1.solve(result, h, start, func3);
				break;
			case 2:
				Formula2 form2 = new Formula2();
				answer = answer + "�� ������� ������ ���������������  ";
				result = form2.solve(result, h, start, func3);
				break;
			case 3:
				Formula3 form3 = new Formula3();
				answer = answer + "�� ������� ��������  ";
				result = form3.solve(result, h, start, func3);
				break;
			default:
				System.out.println("������ ������ ���!");
				break;
			}
			break;
		default:
			System.out.println("����� ������� ���!");
			break;
		}
		System.out.println(answer + "�� ������� [" + start + "," + end + "] �����: " + result);
	}

}
