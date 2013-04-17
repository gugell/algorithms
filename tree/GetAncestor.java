import java.util.*;

public class GetAncestor {
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

		nn4.left = nn2;
		nn4.right = nn6;

		nn2.left = nn1;
		nn2.right = nn3;

		nn6.left = nn5;
		nn6.right = nn7;

		nn12.left = nn10;
		nn12.right = nn14;

		nn10.left = nn9;
		nn10.right = nn11;

		nn14.left = nn13;
		nn14.right = nn15;

		BTreePrinter.printNode(nn8);
		System.out.println(getAncestor(nn13, nn2, nn8).data);
	}

	public static Node getAncestor(Node<Integer> n1, Node<Integer> n2, Node<Integer> n) {
		if (n == null) { return null; }

		if (n.data == n1.data) { return n1; }
		if (n.data == n2.data) { return n2; }

		Node<Integer> left = getAncestor(n1, n2, n.left);
		Node<Integer> right = getAncestor(n1, n2, n.right);

		if (left != null && right != null) {
			return n;
		}

		if (left != null) { return left; }
		if (right != null) { return right; }

		return null;
	}
}

