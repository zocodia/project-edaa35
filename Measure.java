
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//import IO;

public class Measure {

	///////// - dummy data - /////////
	//private static String[] keys = {"a","b","c","d"};
	//private static Integer[] values = {10,20,30,40};
	//////////////////////////////////


	private static ArrayList<String> keys = new ArrayList<>();
	private static ArrayList<Integer> values = new ArrayList<>();
	private static ArrayList<Long> measured = new ArrayList<>();

	private static Map<String, Integer> struct;


	private static void mAdd() {

		System.out.println("Add");

		for (int i = 0; i < IO.nbrIterations; i++) {

			// Start measuring time
			Long start = System.nanoTime();

			// Puts all keys and values in map
			for (int n = 0; n < keys.size(); n++) {
				struct.put(keys.get(n), values.get(n));
			}

			// Stops measuring time
			Long end = System.nanoTime();

			// Writes execution time to output file
			measured.add(end - start);

			// Clear map
			struct.clear();
		}
	}

	private static void mRemove() {

		System.out.println("Remove");

		for (int i = 0; i < IO.nbrIterations; i++) {

			// Puts all keys and values in map
			for (int n = 0; n < keys.size(); n++) {
				struct.put(keys.get(n), values.get(n));
			}

			// Start measuring time
			Long start = System.nanoTime();

			// Removes all keys and values in map
			for (int n = 0; n < keys.size(); n++) {
				struct.remove(keys.get(n));
			}

			// Stops measuring time
			Long end = System.nanoTime();

			// Writes execution time to output file
			measured.add(end - start);
		}
	}

	private static void mFind() {

		System.out.println("Find");

		// Puts all keys and values in map
		for (int n = 0; n < keys.size(); n++) {
			struct.put(keys.get(n), values.get(n));
		}

		for (int i = 0; i < IO.nbrIterations; i++) {

			// Start measuring time
			Long start = System.nanoTime();

			// Searches all keys and values in map
			for (int n = 0; n < keys.size(); n++) {
				struct.get(keys.get(n));
			}

			// Stops measuring time
			Long end = System.nanoTime();

			// Writes execution time to output file
			measured.add(end - start);
		}

	}



	private static void measure(String option) {
		switch (option) {
			case "add"		: mAdd();
							  break;
			case "remove"	: mRemove();
							  break;
			case "find"		: mFind();
							  break;
			default			: System.out.println("No type specified");
							  break;
		}
	}

	public static void main(String[] args) {

		// set parameters from run configuration
		IO.setup(args);


		// read input
		keys = IO.read(IO.fileInputKeys);
		for (String i: (IO.read(IO.fileInputValues))) {
			values.add(Integer.parseInt(i));
		}


		switch (IO.structure) {
			case "tree": {
				struct = new TreeMap<String, Integer>();
				measure(IO.measureType);
			}
			break;
			case "hash": {
				struct = new HashMap<String, Integer>();
				measure(IO.measureType);
			}
			break;
			default: System.out.println("No structure specified");
					 break;
		}

		IO.write(measured);
	}

}
