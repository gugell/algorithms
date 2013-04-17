import java.util.*;

public class SetOfStacks {
	public static void main(String[] args) {
		SetOfStacks sos = new SetOfStacks();

		for (int i = 0; i < 73; i++) {
			sos.push(i);
		}
	}

	int capacity = 10;
	Stack<Stack<Integer>> stacks = new Stack<Stack<Integer>>();
	int size = 0;
	Stack<Integer> current = new Stack<Integer>();

	public void push(int i) {
		if (size % capacity == 0) {
			Stack<Integer> s = new Stack<Integer>();

			if (current != null) {
				stacks.push(current);
				current = s;
			}
		}

		current.push(i);
		size++;
	}

	public int pop() {
		int i = current.pop();

		size--;

		if (size % capacity == 0) {
			stacks.pop();
		}

		return i;
	}
}

