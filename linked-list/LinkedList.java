import java.util.ArrayList;
import java.util.*;

class LinkedList {

	public static void main(String[] args) {
		Node n = new Node(100);
		n.appendToTail(1);
		n.appendToTail(123);
		n.appendToTail(2);
		n.appendToTail(1000);
		n.appendToTail(3);
		n.appendToTail(99999);
		n.appendToTail(3);
		n.appendToTail(3);
		n.appendToTail(66);
		n.appendToTail(77);
		n.appendToTail(3);
		n.appendToTail(2);
		n.appendToTail(123);
		n.appendToTail(123);

		Node a = new Node(10);
		Node b = new Node(20);
		Node c = new Node(30);
		Node d = new Node(40);
		Node e = new Node(50);

		a.appendToTail(b);
		a.appendToTail(c);
		a.appendToTail(d);
		e.appendToTail(c);
		a.appendToTail(e);

		System.out.println(Node.getCorruptNode(a).data);
	}

	public static class Node {
		Node next = null;
		int data = 0;

		public Node(int d) {
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

		public void appendToTail(Node end) {
			Node n = this;

			while (n.next != null) {
				n = n.next;
			}
			
			n.next = end;
		}

		public void removeDuplicates() {
			Node n = this;

			ArrayList nodes = new ArrayList();

			while (n.next != null) {
				Node next = n.next;

				if (nodes.contains(next.data)) {
					n.next = next.next;
				}
				else {
					n = n.next;
				}

				nodes.add(n.data);
			}
		}

		public int getKthToLast(int kth) {
			Node n = this;

			if (n.next == null) { return 0; }
		
			int count = 1;

			while (n.next != null) {
				count++;
				n = n.next;
			}

			if (count < kth) { return 0; }

			int index = count - kth + 1;
			count = 1;
			n = this;

			while (n.next != null) {
				if (count == index) { 
					return n.data;
				}

				count++;
				n = n.next;
			}

			return 0;
		}

		public static int getKth(Node n, int kth) {
			int count = 1;

			if (n.next != null) {
				count = getKth(n.next, kth);

				if (count == kth) { 
					System.out.println(n.data + " " + kth);
				}
			}

			count++;

			return count;
		}
	
		public static void printValues(Node n) {
			System.out.print(n.data + ",");
			if (n.next != null) {
				Node.printValues(n.next);
			}

			System.out.println("");
		}

		public static Node partition(Node n, int p) {
			if (n == null) { return new Node(0); }
			if (n.next == null) { return n; }

			Node head = n;

			while (n.next != null) {
				if (n.next.data < p) {
					Node newhead = n.next;
					n.next = n.next.next;
					newhead.next = head;
					head = newhead;
				}
				else 
				{
					n = n.next;
				}
			}

			return head;
		}

		public static double getSum(Node n, int power) {
			if (n == null) { return 0; }

			double i = Math.pow(10, power);
			double sum = 0;

			sum = getSum(n.next, power + 1) + (i * n.data);

			return sum;
		}

		public static Node genNode(int sum) {
			int length = Integer.toString(sum).length();
			Node[] nodes = new Node[length];

			for (int i = length - 1; i >= 0; i--) {
				double ten = Math.pow(10, i);
				int nodeData = sum / (int)ten;
				int mod = sum % (int)ten;
				Node n = new Node(nodeData);
				nodes[i] = n;
				sum = mod;
			}

			Node head = new Node(nodes[0].data);

			for (int i = 1; i < nodes.length; i++) {
				head.appendToTail(nodes[i].data);
			}

			return head;
		}

		public static boolean isPalindrome(Node n) {
			StringBuilder sb = new StringBuilder();

			while (n.next != null) {
				sb.append((char)n.data);
				n = n.next;
			}

			sb.append((char)n.data);
			String str = sb.toString();
			String backwards = reverseString(str);
			
			if (str.equals(backwards)) {
				return true;
			}

			return false;
		}

		public static String reverseString(String str) {
			char[] chars = str.toCharArray();

			for (int i = 0; i < str.length() / 2; i++) {
				char c = chars[i];
				chars[i] = chars[str.length() - i - 1];
				chars[str.length() - i - 1] = c;
			}

			return new String(chars);
		}

		public static Node getCorruptNode(Node n) {
			HashMap map = new HashMap();

			while (n.next != null) {
				if (map.containsKey(n)) {
					return n;
				}

				map.put(n, 1);
				n = n.next;
			}
		
			return new Node(0);
		}
	}
}

