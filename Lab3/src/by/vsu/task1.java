package by.vsu;

import java.util.Arrays;

public class task1 {
	public static void main(String[] args) {
		System.out.println("�������� ������: ");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("������ ����������: ");
        Arrays.sort(args, new StringContanceCompatator());
        System.out.println("���������� ����������: ");
        System.out.println(StringContanceCompatator.count1);
        System.out.println("������: ");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("������ ����������: ");
        Arrays.sort(args, new StringLengthCompatator());
        System.out.println("���������� ����������: ");
        System.out.println(StringLengthCompatator.count);
        System.out.println("������: ");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

        }

    }
	

}
