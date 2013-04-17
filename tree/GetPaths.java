import java.util.*;

public class GetPaths {
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
		List<LinkedList<Integer>> paths = getPaths(nn8);
		System.out.println(paths.size());
	}

	public static int sum = 14;

	public static List<LinkedList<Integer>> getPaths(Node<Integer> root) {
		List<LinkedList<Integer>> paths = new ArrayList<LinkedList<Integer>>();
		LinkedList<Node<Integer>> nodes = new LinkedList<Node<Integer>>();

		getNodes(root, nodes);

		for (Node<Integer> n : nodes) {
			LinkedList<Integer> p = new LinkedList<Integer>();
			getOkPaths(n, paths, p);  
		}

		return paths;
	}

	public static void getNodes(Node<Integer> n, LinkedList<Node<Integer>> nodes) {
		if (n == null) { return; }
		nodes.add(n);
		getNodes(n.left, nodes);
		getNodes(n.right, nodes);
	}

	public static void getOkPaths(Node<Integer> n, List<LinkedList<Integer>> paths, LinkedList<Integer> path) {
		if (n == null) { return; }
		path.add(n.data);
	
		if (isValidPath(path)) {
			for (Integer i : path) {
				System.out.print("" + i + ",");
			}
			System.out.println("...");
			paths.add(path);
		}

		getOkPaths(n.left, paths, path);
		getOkPaths(n.right, paths, path);
		path.removeLast();
	}

	public static Boolean isValidPath(LinkedList<Integer> path) {
		int s = 0;
		for (Integer i : path) {
			s = s + i;
		}
		return s == sum;
	}
}
