import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RunTree {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int size = 0;
		List<String> lines = new ArrayList<String>();
		boolean usingFile = true;
		if (args.length == 0) {
			usingFile = false;
		}
		if (args.length > 1) {
			System.out.println("Too many arguments");
			System.exit(0);
		}
		if(usingFile){
			try{
				lines = Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
			}
			catch (IOException e){
				System.out.println("Something went wrong");
			}	
			size = lines.size();
		}
		RST tree = new RST();


		if(usingFile) {
			try {
	
				File file = new File("output.txt");
	
				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}
	
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
					
				for(int i = 0; i < size; i++) {
					char operation = lines.get(i).charAt(0);
					int number = Integer.parseInt(lines.get(i).substring(2));
					switch (operation) {
						case 'I':	tree.insert(number);
									bw.write("S\n");
									break;
						case 'D': 	if (tree.delete(number)) {
										bw.write("S\n");
									}
									else {
										bw.write("F\n");
									}
									break;
						case 'S': 	if (tree.find(number)) {
										bw.write("S\n");
									}
									else {
										bw.write("F\n");
									}
									break;
						default:	System.out.println("unknown operation");		
					}
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Write I for insert, D for delete, S for search,\n" +
					"followed by whitespace and the number you wish to insert/delete/find.\n" +
					"(Example: 'I 2' inserts the number 2)\nQ quits. P prints the current tree");
			while(true){
				String inp = sc.nextLine();

				char operation = inp.charAt(0);
				if (operation == 'Q') {
					System.exit(1);
				}
				
				switch (operation) {
					case 'I':	
								int number = Integer.parseInt(inp.substring(2));
								tree.insert(number);
								System.out.println("Inserted " + number);
								break;
					case 'D': 	number = Integer.parseInt(inp.substring(2));
								if (tree.delete(number)) {
									System.out.println("deleted " + number);
								}
								break;
					case 'S': 	number = Integer.parseInt(inp.substring(2));
								if (tree.find(number)) {
									System.out.println("Found " + number);
								}
								else {
									System.out.println("Did not find " + number);
								}
								break;
					case 'P':	System.out.println();
								tree.traverseTree();
								System.out.println();
								break;
					default:	System.out.println("unknown operation");		
				}
			}
		}
	}
}