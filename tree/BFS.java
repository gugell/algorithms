import java.util.*;

public class BFS {
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

		BTreePrinter.printNode(root);

		List<LinkedList<Node>> levels = getLevels(root);

		for (LinkedList<Node> level : levels) {
			System.out.println(level.size());
			for (Node n : level) {
				System.out.print(n.data + ",");
			}
		}
	}

	public static List<LinkedList<Node>> getLevels(Node root) {
		List<LinkedList<Node>> levels = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		levels.add(current);
		
		LinkedList<Node> newList = new LinkedList<Node>();

		int size = current.size();
		while (size > 0) {
			for (Node n : current) {
				if (n.left != null) { newList.add(n.left); }
				if (n.right != null) { newList.add(n.right); }
			}

			levels.add(newList);
			current.clear();
			current.addAll(newList);
			newList.clear();
			size = current.size();
		}

		return levels;
	}
}
