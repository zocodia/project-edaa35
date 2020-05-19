
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {

	static String fileInputKeys;
	static String fileInputValues;
	static String fileOutput;
	static Integer nbrIterations;
	static String structure;
	static String measureType;


	static void setup(String[] args) {

		// -fileNameKeys -fileNameValues -fileNameOutput -nbrIterations -Structure -measureType
		fileInputKeys 	= args[0];
		fileInputValues = args[1];
		fileOutput		= args[2];
		nbrIterations 	= Integer.parseInt(args[3]);
		structure		= args[4];
		measureType		= args[5];

	}

	static ArrayList<String> read(String file) {

		ArrayList<String> list = new ArrayList<>();

		try {

			Scanner s = new Scanner(new File(file));
			s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();

		} catch (FileNotFoundException e) {
			System.out.println("Input-file not found");
		}

		return list;
	}

	static <E> void write(ArrayList<E> data) {

		try {

			PrintWriter p = new PrintWriter(new File(fileOutput));

			p.print("iteration, measured\n");

			for (int i = 0; i < nbrIterations; i++) {
				p.println((i+1) + ", " + data.get(i));
			}
			p.close();

		} catch (FileNotFoundException e) {
			System.out.println("Output-file not found");
		}
	}

}
