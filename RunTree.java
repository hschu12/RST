public class RunTree{

	public static void main(String[] args) {
		RST tree = new RST();
		RST tree1 = new RST();
		RST tree2 = new RST();

		tree.insert(10);
		tree.insert(19);
		tree.insert(5);
		tree.insert(4);
		tree.insert(12);
		tree.insert(42);
		tree.insert(22);
		tree.insert(34);

		/*tree.find(10);
		tree.find(19);
		tree.find(5);*/
		
		/* Test of delete */
/*
		System.out.println("TEST OF MERGE ");
		System.out.println("");
		tree.traverseTree();
		System.out.println("");

		tree.delete(tree.root.key);


		System.out.println("");
		tree.traverseTree();
		System.out.println("");

*/

		/* Test of split */
/*		
		RST[] arr = tree.split(9);
		
		System.out.println("left");
		arr[0].traverseTree();
		System.out.println("");


		System.out.println("right");
		arr[1].traverseTree();
		System.out.println("");
*/


		/* Test of merge */

/*
		System.out.println("TEST OF MERGE ");
		tree1.insert(19);
		tree1.insert(5);
		tree1.insert(29);
		tree1.insert(6);
		tree1.insert(42);
		
		tree2.insert(109);
		tree2.insert(298);
		tree2.insert(194);
		tree2.insert(288);
		tree2.insert(198);

		System.out.println("");
		tree1.traverseTree();
		System.out.println("");

		tree1.merge(tree1, tree2);

		System.out.println("");
		tree1.traverseTree();
		System.out.println("");
*/
	}

}