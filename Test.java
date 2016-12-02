import java.util.ArrayList;
import java.util.Collections;


public class Test {
	
	public static void main(String[] args) {

		int pointerusedRange = 30;
		int[] pointersUsedForSearch = new int[pointerusedRange];

		/***********************************************************
		* Test of Average Search Complexity                        *
		* Permuted input.                                          *
		***********************************************************/

		System.out.println("Average Search Complexity - Permute-Order");
		int i;
		int size = 0;

		ArrayList<Integer> permutedAverage = new ArrayList<Integer>();
		for (i = 0; i < 1000; i++) {
			permutedAverage.add(i);
		}
		Collections.shuffle(permutedAverage);

		RST tree;

		while( size < 950 ) {
			size = size + 50;
			tree = new RST();
			double acumulatedPointers = 0;
			System.out.print("Size of n = " + size);

			for (i = 0; i < size; i++) {
				tree.insert(permutedAverage.get(i));
			}

			for (i = 0; i < 10000; i++) {
				int x = (int) (Math.random() * size);
				tree.find(x);
				acumulatedPointers = acumulatedPointers + tree.pointersused;
			}
				
			double averagePointersUsed = acumulatedPointers / 10000;
		
			System.out.println("\t Average: " + averagePointersUsed);
		}

		/***********************************************************
		* Test of Variation in search complexity                   *
		* Permuted input.                                          *
		***********************************************************/

		System.out.println();
		System.out.println("Variation in search complexity: Permuted list");

		ArrayList<Integer> permuted = new ArrayList<Integer>();
		for (i = 0; i < 1000; i++) {
			permuted.add(i);
		}
		Collections.shuffle(permuted);

		RST tree1 = new RST();

		for (i = 0; i < 1000; i++) {
			tree1.insert(permuted.get(i));
		}

		for ( i = 0; i < pointerusedRange; i++ ) {
			pointersUsedForSearch[i] = 0;	
		}

		for (i = 0; i < 10000; i++) {
			int x = (int) (Math.random() * 1000);
			tree1.find(x);
			pointersUsedForSearch[tree1.pointersused]++;
		}
		for ( i = 0; i < pointerusedRange; i++ ) {
			int j = i+1;
			System.out.println(j + ": " + pointersUsedForSearch[i]);
		}
	}
}