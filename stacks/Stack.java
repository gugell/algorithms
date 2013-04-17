public class Stack {
	public static void main (String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(2);
		Node n3 = new Node(9);
		Node n4 = new Node(8);
		Node n5 = new Node(1);

		Stack s = new Stack();
		s.push(n1);
		s.push(n2);
		s.push(n3);
		s.push(n4);
		s.push(n5);

		System.out.println(s.min);
		System.out.println(s.pop());
		System.out.println(s.min);
	}

	public static class Node {
		int data;
		int old_min;
		Node next;

		public Node(int d) {
			data = d;
		}

		public void setOldMin(int min) {
			old_min = min;
		}

		public int getOldMin() {
			return old_min;
		}
	}

	Node top;
	int min = Integer.MAX_VALUE;
	
	public void push(Node n) {
		if (n.data < min) {
			n.setOldMin(min);
			min = n.data;
		}

		n.next = top;
		top = n;
	}

	public int pop() {
		if (top.data == min) {
			min = top.getOldMin();
		}

		int n = top.data;
		top = top.next;
		return n;
	}
}

