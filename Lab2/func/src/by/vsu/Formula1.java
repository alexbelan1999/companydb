package by.vsu;

public class Formula1 implements Formula {
	public double solve(double result, double h, double start, Function func) {
		for (int i = 0; i < 1000; i++) {
			
			result +=func.result(start + i * h);
			
		}
		result *= h;
		return result;
	};
}
