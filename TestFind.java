public class TestFind {
	
	public static void main(String[] args) {
		RST tree = new RST();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);

		tree.traverseTree();

		System.out.println();

		System.out.print("locate 3: ");
		tree.find(3);

		System.out.print("locate 6: ");
		tree.find(6);

		System.out.print("locate 7: ");
		tree.find(7);
	}

}