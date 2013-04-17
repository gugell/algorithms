import java.util.*;

public class GetNext {
	public static void main(String[] args) {
		Node<Integer> nn8 = new Node<Integer>(8);
		Node<Integer> nn4 = new Node<Integer>(4);
		Node<Integer> nn2 = new Node<Integer>(2);
		Node<Integer> nn1 = new Node<Integer>(1);
		Node<Integer> nn3 = new Node<Integer>(3);
		Node<Integer> nn6 = new Node<Integer>(6);
		Node<Integer> nn5 = new Node<Integer>(5);
		Node<Integer> nn7 = new Node<Integer>(7);
		Node<Integer> nn12 = new Node<Integer>(12);
		Node<Integer> nn10 = new Node<Integer>(10);
		Node<Integer> nn9 = new Node<Integer>(9);
		Node<Integer> nn11 = new Node<Integer>(11);
		Node<Integer> nn14 = new Node<Integer>(14);
		Node<Integer> nn13 = new Node<Integer>(13);
		Node<Integer> nn15 = new Node<Integer>(15);

		nn8.left = nn4;
		nn8.right = nn12;
		nn8.parent = null;

		nn4.left = nn2;
		nn4.right = nn6;
		nn4.parent = nn8;

		nn2.left = nn1;
		nn2.right = nn3;
		nn2.parent = nn4;

		nn6.left = nn5;
		nn6.right = nn7;
		nn6.parent = nn4;

		nn12.left = nn10;
		nn12.right = nn14;
		nn12.parent = nn8;

		nn10.left = nn9;
		nn10.right = nn11;
		nn10.parent = nn12;

		nn14.left = nn13;
		nn14.right = nn15;
		nn14.parent = nn12;

		nn1.parent = nn2;
		nn3.parent = nn2;
		nn5.parent = nn6;
		nn7.parent = nn6;
		nn9.parent = nn10;
		nn11.parent = nn10;
		nn13.parent = nn14;
		nn15.parent = nn14;

		BTreePrinter.printNode(nn8);
		System.out.println(getNext(nn15).data);
	}

	public static Node<Integer> getNext(Node<Integer> n) {
		if (n.left == null && n.right == null) {
			Node<Integer> parent = n.parent;
			if (parent.left.data == n.data) {
				return parent;
			}

			while (parent.right.data == n.data) {
				n = parent;
				parent = n.parent;
			}

			return parent;
		} else {
			Node<Integer> right = n.right;
			if (right.left == null && right.right == null) {
				return right;
			}

			while (right.left != null) {
				right = right.left;
			}

			return right;
		}
	}
}
