package task1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите строку: ");
        String str= scanner.nextLine();
        System.out.println(str);
        Queue queue = new Queue();
        for (int n = 0; n < str.length(); n++) {
        	char symbol = str.charAt(n);
        	if (symbol == '(' || symbol == ')' || symbol == '[' || symbol == ']' || symbol == '{' || symbol == '}' || symbol == '<' || symbol == '>') {
        		queue.add(symbol);
        	}
        }
        System.out.println("count: " + queue.count());
        System.out.println("Queue");
        queue.print();
        StackArray stack = new StackArray(queue.count());
        int count = queue.count();
        boolean answer = true;
        for (int m = 0; m < count ; m++) {
        	System.out.println(m);
        	char test = queue.remove().toString().charAt(0);
        	System.out.println(test);
        	stack.push(test);
        }
        
        System.out.println("Stack");
        if (count % 2 == 0) {
        	char test = stack.peek();
        	if ( test == '(' || test == '[' || test == '{' || test == '<') {
        		answer = false;
        	} else { 
        		for (int m = 0; m < count/2 ; m++) {
        			char test1 = stack.pop();
        			char test2 = stack.pop();
        			
                	if ((test1 == ')' && test2 != '(') || (test1 == ']' && test2 != '[') || (test1 == '}' && test2 != '{') || (test1 == '>' && test2 != '<') || test1 == '(' || test1 == '[' || test1 == '{' || test1 == '<') {
                		answer = false;
                	}
                	
                	System.out.println(test2 + " " + test1);
        		
        		}	
        	}
        } else {
        	answer = false;
        }
        System.out.println("Answer: " + answer);
        
    }
}
