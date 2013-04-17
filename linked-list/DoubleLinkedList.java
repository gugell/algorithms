class DoubleLinkedList {
	public static void main(String[] args) {
		Node n = new Node(10);
		n.appendToTail(20);
		n.appendToTail(30);

		System.out.println(n.getNext().getData());	
	}

	public static class Node {
		int data = 0;
		Node prev = null;
		Node next = null;

		public Node(int d ) {
			data = d;
		}
	
		public void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;

			while (n.next != null) {
				n = n.next;
			}

			n.next = end;
		}

		public Node getPrev() {
			return prev;
		}

		public Node getNext() {
			return next;
		}

		public int getData() {
			return data;
		}
	}
}

