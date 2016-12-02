public class TestDelete {
	
	public static void main(String[] args) {
		RST tree = new RST();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);

		tree.traverseTree();

		tree.delete(2);

		tree.traverseTree();
	}

}