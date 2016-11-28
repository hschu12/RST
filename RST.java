import java.util.Random;
import java.lang.Math;

public class RST {

	Node root;

	public RST(){
		root = null;
	}

	private RST(Node n) {
		root = n;
	}

	public void insert(int key) {
		Node y = null;
		Node x = root;
		long priority = generateRandomPriority();
		Node nodeToInsert = new Node(priority, key);
		while (x != null) {
			y = x;
			if (nodeToInsert.key < x.key) {
				x = x.leftChild;
			}
			else {
				x = x.rightChild;
			}
		}
		nodeToInsert.parent = y;
		if (y == null) {
			root = nodeToInsert;
		}
		else if ( nodeToInsert.key < y.key ) {
			y.leftChild = nodeToInsert;
		}
		else {
			y.rightChild = nodeToInsert;
		}
		treeFixup(nodeToInsert);
	}

	/***************************************************
	* Findes note that contains the given key. Rotates *
	* it down until it is a leaf.                      *
	* Then deletes it without having fix               *
	***************************************************/

	public boolean delete(int key) {
		Node nodeToDelete = locate(key);
		if (nodeToDelete == null) {
			System.out.println("Does not exists");
			return false;
		}
		return delete(locate(key));
	}

	private boolean delete(Node n) {
		if (is_leaf(n)) {
			System.out.println("deleting: " + n.key);
			if (n.parent.leftChild == n){
				n.parent.leftChild = null;
			}
			else {
				n.parent.rightChild = null;
			}
			n = null;
			return true;
		}

		long leftp = Long.MAX_VALUE;
		long rightp = Long.MAX_VALUE;
		if (n.leftChild != null) {
			leftp = n.leftChild.priority;
		}
		if (n.rightChild != null) {
			rightp = n.rightChild.priority;
		}

		if (leftp < rightp) {
			right_rotate(n);
			return delete(n);
		}
		else {
			left_rotate(n);
			return delete(n);
		}
	}

	private boolean is_leaf(Node n) {
		return (n.leftChild == null &&  n.rightChild == null);
	}

	public boolean find(int key) {
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.key == key) {
				System.out.println("Found");
				return true;
			}
			else if ( currentNode.key > key) {
				currentNode = currentNode.leftChild;
			}
			else {
				currentNode = currentNode.rightChild;
			}	
		}
		System.out.println("Not found");
		return false;
	}

	public Node locate(int key) {
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.key == key) {
				return currentNode;
			}
			else if ( currentNode.key > key) {
				currentNode = currentNode.leftChild;
			}
			else {
				currentNode = currentNode.rightChild;
			}	
		}
		return null;
	}

	public RST[] split(int key) {
		RST[] returnArray = new RST[2];
		long priority = -1;
		Node splitNode = new Node(priority, key);
		Node y = null;
		Node x = root;
		while (x != null) {
			y = x;
			if (splitNode.key < x.key) {
				x = x.leftChild;
			}
			else {
				x = x.rightChild;
			}
		}
		splitNode.parent = y;
		if (y == null) {
			root = splitNode;
		}
		else if ( splitNode.key < y.key ) {
			y.leftChild = splitNode;
		}
		else {
			y.rightChild = splitNode;
		}
		treeFixup(splitNode);

		RST treeLeft = new RST(splitNode.leftChild);

		RST treeRight = new RST(splitNode.rightChild);
		
		returnArray[0] = treeLeft;
		returnArray[1] = treeRight;
		return returnArray;
	}

	/***************************************************
	* Takes two trees and merges them. Using a dummy   *
	* node as the root of the merged tree, and then    *
	* delete the dummy node afterwards.                *
	***************************************************/

	/*
	When tree1 is smallest left child is out of order
	*/

	public void merge(RST tree1, RST tree2) {
		long priority = -1;
		int key = 0;
		Node dummy = new Node(priority, key);
		dummy.leftChild = tree1.root;
		tree1.root.parent = dummy;
		dummy.rightChild = tree2.root;
		tree2.root.parent = dummy;
		tree1.root = dummy;
		tree2.root = dummy;
		traverseTree(root);
		delete(key);
	}

	private void treeFixup(Node z){
		while (z.parent != null && z.parent.priority > z.priority) {
			if (z.parent.leftChild == z) {
				right_rotate(z.parent);
			}
			else if (z.parent.rightChild == z) {
				left_rotate(z.parent);
			}
		}
	}

	private void left_rotate(Node x){
		Node y = x.rightChild;
		x.rightChild = y.leftChild;
		if ( y.leftChild != null ) {
			y.leftChild.parent = x;
		} 
		y.parent = x.parent;
		if ( x.parent == null ) {
			root = y;
		}
		else if ( x == x.parent.leftChild ) {
			x.parent.leftChild = y;
		}
		else {
			x.parent.rightChild = y;
		}
		y.leftChild = x;
		x.parent = y;
	}

	private void right_rotate(Node x){
		Node y = x.leftChild;
		x.leftChild = y.rightChild;
		if ( y.rightChild != null ) {
			y.rightChild.parent = x;
		} 
		y.parent = x.parent;
		if ( x.parent == null ) {
			root = y;
		}
		else if ( x == x.parent.rightChild ) {
			x.parent.rightChild = y;
		}
		else {
			x.parent.leftChild = y;
		}
		y.rightChild = x;
		x.parent = y;
	}

	private long generateRandomPriority() {
		Random r = new Random();
		long priority = Math.abs(r.nextLong());
		return priority;
	}

	public void traverseTree() {
		traverseTree(root);
	}

	private void traverseTree(Node x) {
		if (x != null) {
			System.out.println("priority: " + x.priority + " hit: " + x.key);
		}
		if (x.leftChild != null) {
			System.out.println("Go left");
			traverseTree(x.leftChild);
			System.out.println("Back");
		}
		if (x.rightChild != null) {
			System.out.println("Go right");
			traverseTree(x.rightChild);
			System.out.println("Back");
		}
	}



}