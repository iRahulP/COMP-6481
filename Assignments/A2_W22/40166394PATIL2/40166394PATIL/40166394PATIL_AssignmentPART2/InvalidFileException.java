package p2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author rahul
 * throws an Error if trying to read an invalid file other than the one required for the Sales Application to Process
 */
public class InvalidFileException extends Exception {
	private static String logFilePath = "/Users/rahul/eclipse-workspace/Assignment2/src/p2/log.txt";
//	private static String logFilePath = "./"+log_fileName;

	private static final long serialVersionUID = -4226908821133276791L;

	public InvalidFileException(String fName) throws IOException {
		FileWriter output = new FileWriter(logFilePath, true);
    	output.write("Error: Input file named "+fName+" cannot be found.\n");
    	output.close();
		System.out.println("Error: Input file named "+fName+" cannot be found.");
	}
	
}
