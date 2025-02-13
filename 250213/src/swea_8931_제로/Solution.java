package swea_8931_제로;

import java.util.Scanner;

class MyStack<T> {
    private T[] stack;
    private int top = -1;

    public MyStack(int k) {
        stack = (T[]) new Object[k];
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("비었다");
            return null;
        } 
        return stack[top];
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("비었다");
            return null;
        }
        T tmp = stack[top];
        stack[top--] = null;
        return tmp;
    }

    public boolean push(T i) {
        if (isFull()) {
            System.out.println("자리 없다");
            return false;
        }
        stack[++top] = i;
        return true;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

public class Solution {
	static MyStack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int k = sc.nextInt();
			stack = new MyStack<>(k);
			
			for(int i=0; i<k; i++) {
				int num = sc.nextInt();
				if(num != 0) {
					stack.push(num);
				} else {
					stack.pop();
				}
			}
			
			int sum = 0;
			int size = stack.size();
			for(int i=0; i<size; i++) {
				sum += stack.pop();
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}