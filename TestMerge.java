public class TestMerge {
	
	public static void main(String[] args) {
		RST tree = new RST();
		RST tree1 = new RST();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree1.insert(4);
		tree1.insert(5);
		tree1.insert(6);

		System.out.println("Printing tree 1:");
		tree.traverseTree();

		System.out.println();
		System.out.println("Printing Tree 2:");
		tree1.traverseTree();

		tree.merge(tree, tree1);

		System.out.println();
		System.out.println("Printing merged T1, T2:");
		tree.traverseTree();
	}

}