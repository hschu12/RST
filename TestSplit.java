public class TestSplit {
	
	public static void main(String[] args) {
		RST tree = new RST();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);

		tree.traverseTree();

		RST[] arr = tree.split(3);

		System.out.println();
		System.out.println("Tree 1:");
		arr[0].traverseTree();

		System.out.println();
		System.out.println("Tree 2:");
		arr[1].traverseTree();
	}

}