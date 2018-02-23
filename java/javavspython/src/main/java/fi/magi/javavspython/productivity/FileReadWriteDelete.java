package fi.magi.javavspython.productivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * 
 * 
 * @author magi
 */
public class FileReadWriteDelete {

    /** Delete a file gracefully, first checking that it exists. */
	private static void deleteFile(String filename) {
		File file = new File(filename);
		try {
			// There's actually a handy utility function for this!
			Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			// Notice that this exception handling was FORCED by Java
			e.printStackTrace();
		}
	}

    /** Create a file and write some data into it. */
	private static void writeFile(String filename) {
		// Create some data
		ArrayList<Integer> data = new ArrayList<Integer>(20);
		data.add(1);
		data.add(1);
		for (int i=2; i < 20; i++)
			data.add(data.get(i-1) + data.get(i-2));
		
		// Open the file for writing
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}

		// Write the data to the file
		for (Integer line: data)
			writer.printf("number=%d\n", line);

		writer.close();		
	}

    /** Read a file and process the data in it. */
	private static void readFile(String filename) {
		File file = new File(filename);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    // Read the file line by line
		    while ((line = br.readLine()) != null) {
		    	String[] items = line.split("=");
		    	System.out.printf("Read value %d\n", Integer.parseInt(items[1]));
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final String filename = "testfile.txt";
	    deleteFile(filename);
	    writeFile(filename);
	    readFile(filename);
	    deleteFile(filename);
	}

}
