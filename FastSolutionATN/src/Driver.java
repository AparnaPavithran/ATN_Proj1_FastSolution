/** Sample driver program using the graph class
 *  
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
	Scanner in;
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }
	Graph.readDirectedGraph(in);

	
    }
}


