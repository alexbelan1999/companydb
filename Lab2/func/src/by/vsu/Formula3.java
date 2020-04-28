package by.vsu;

public class Formula3 implements Formula {
	public double solve(double result, double h, double start, Function func) {
		for (int i = 0; i <1000; i++) {
			
			double sum = 0;
			sum = ((start + (i+1) * h) + (start + i * h))/2;
			result +=func.result(sum);

		}
		result *= h;
		return result;
	};
}
