package task1;

public class StackArray {
	private int size;
	private char[] array;
	private int top;
	
	public StackArray(int s) {
		size = s;
		array = new char[size];
		top = -1;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
        return (top == size - 1);
    }
	public void push(char c) {
		int i = ++top;
		array[i] = c;
	}
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return 0;
		
		}
		else {
			return array[top--];
			
		}
	}
	public char peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return 0;
		
		}
		else {
			return array[top];
			
		}
	}
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
		}
		else {
			for(int n = 0; n < size; n++ )
			System.out.println(pop());
		}
	}

}
