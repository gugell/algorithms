public class BST {
	public static int[] ints = new int[10];

	public static void main(String[] args) {
		ints[0] = 50;
		ints[1] = 60;
		ints[2] = 78;
		ints[3] = 80;
		ints[4] = 90;
		ints[5] = 100;
		ints[6] = 110;
		ints[7] = 150;
		ints[8] = 200;
		ints[9] = 210;

		Node<Integer> root = getBST(0, 9);
		BTreePrinter.printNode(root);
	}

	public static Node<Integer> getBST(int start, int end) {
		if (start > end) { return null; }

		double d = (start + end) / 2;	
		int mid = (int)Math.floor(d);
		Node<Integer> n = new Node<Integer>(ints[mid]);

		n.left = getBST(start, mid - 1);
		n.right = getBST(mid + 1, end);

		return n;
	}
}
