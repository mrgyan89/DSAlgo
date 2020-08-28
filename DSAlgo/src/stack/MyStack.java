package stack;

public class MyStack<E> {
	private Object[] stack;
	private int top = -1;

	public MyStack(int size) {
		stack = new Object[size];
	}

	public void push(E data) {
		if (isFull()) {
			throw new IllegalArgumentException("Stack is full");
		}
		top++;
		stack[top] = data;
	}

	public E pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stack is empty");
		}
		Object item = stack[top];
		if (item != null) {
			stack[top] = null;
			top--;
		}
		return (E) item;
	}

	public void traverse() {
		for (int i = stack.length - 1; i > -1; i--) {
			if (stack[i] != null) {
				System.out.print("[" + stack[i] + "]\n");
			}
		}
	}

	public int size() {
		return top + 1;
	}

	public boolean isFull() {
		return top >= stack.length - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args) {
		MyStack<Integer> mystack = new MyStack<Integer>(5);
		System.out.print("Total items in Stack: " + mystack.size() + "\n");
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		mystack.push(5);
		mystack.traverse();
		System.out.print("Total items in Stack: " + mystack.size() + "\n");
		System.out.println("Poped item from stack: " + mystack.pop());
		System.out.print("Total items in Stack: " + mystack.size() + "\n");
		mystack.push(6);
		mystack.traverse();

	}

}