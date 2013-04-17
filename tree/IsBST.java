import java.util.*;

public class IsBST {
	public static void main(String[] args) {
    	   	Node<Integer> root = new Node<Integer>(2);
       		Node<Integer> n11 = new Node<Integer>(7);
        	Node<Integer> n12 = new Node<Integer>(5);
        	Node<Integer> n21 = new Node<Integer>(2);
        	Node<Integer> n22 = new Node<Integer>(6);
        	Node<Integer> n23 = new Node<Integer>(3);
        	Node<Integer> n24 = new Node<Integer>(6);
        	Node<Integer> n31 = new Node<Integer>(5);
        	Node<Integer> n32 = new Node<Integer>(8);
        	Node<Integer> n33 = new Node<Integer>(4);
        	Node<Integer> n34 = new Node<Integer>(5);
        	Node<Integer> n35 = new Node<Integer>(8);
        	Node<Integer> n36 = new Node<Integer>(4);
        	Node<Integer> n37 = new Node<Integer>(5);
        	Node<Integer> n38 = new Node<Integer>(8);

        	root.left = n11;
        	root.right = n12;

        	n11.left = n21;
        	n11.right = n22;
        	n12.left = n23;
        	n12.right = n24;

        	n21.left = n31;
        	n21.right = n32;
        	n22.left = n33;
        	n22.right = n34;
        	n23.left = n35;
        	n23.right = n36;
  	        n24.left = n37;
	        n24.right = n38;

                Node<Integer> root2 = new Node<Integer>(27);
                Node<Integer> n19 = new Node<Integer>(19);
                Node<Integer> n30 = new Node<Integer>(30);
                Node<Integer> n17 = new Node<Integer>(17);
                Node<Integer> n26 = new Node<Integer>(26);
                Node<Integer> n28 = new Node<Integer>(1);
                Node<Integer> n50 = new Node<Integer>(50);

                root2.left = n19;
                root2.right = n30;

                n19.left = n17;
                n19.right = n26;
                n30.left = n28;
                n30.right = n50;

		BTreePrinter.printNode(root);
		System.out.println(isBST(root));
	
		BTreePrinter.printNode(root2);
		System.out.println(isBST2(root2, new Stack<Integer>()));

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
		System.out.println(isBST2(nn8, new Stack<Integer>()));
	}

	public static Boolean isBST(Node<Integer> n) {
		if (n == null) { return true; }

		int root = n.data;

		if (n.left != null && n.left.data > root) {
			return false;
		}

		if (n.right != null && n.right.data < root) { 
			return false;
		}

		Boolean leftOk = isBST(n.left);
		if (!leftOk) { return false; }

		Boolean rightOk = isBST(n.right);
		if (!rightOk) { return false; }

		return true;
	}

	public static Boolean isBST2(Node<Integer> n, Stack<Integer> s) {
		if (n == null) { return true; }

		Boolean leftOk = isBST2(n.left, s);

		if (!s.empty()) {
			int prev = s.pop();
			if (n.data < prev) { 
				return false;
			}
		}

		s.push(n.data);

		Boolean rightOk = isBST2(n.right, s);

		return leftOk && rightOk;
	}
}

