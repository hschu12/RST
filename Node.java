public class Node {

	Node leftChild;
	Node rightChild;
	Node parent;
	long priority;
	int key;

	public Node (long p, int k) {
		leftChild = null;
		rightChild = null;
		parent = null;
		priority = p;
		key = k;
	}



}