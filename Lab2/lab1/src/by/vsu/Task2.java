package by.vsu;

public class Task2 {
    
    public static double expression(double x) {
        return Math.sin(x);
    }
	
    public static double expression1(double x, double accuracy) {
	double term = ((-1)*x*x*x)/6;
	double sum = x + term;
	int n = 1;
	while (Math.abs(term) > accuracy)
	{
	  term = term * (-1)*x*x/((2*n+3)*(2*n+2));
	  sum = sum + term;
	  n++;
	}
	
        return sum;
    }
    public static void main(String[] args) {
	if (args.length == 2){
        	double x = Double.parseDouble(args[0]);
		double accuracy = Double.parseDouble(args[1]);
		System.out.println("sin(x):");
        	System.out.println(expression(x));
		System.out.println("sum:");
        	System.out.println(expression1(x,accuracy));
	}
	else System.out.println("Error: Wrong parameters!");
    }
}