package p2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author rahul
 * throws an Error if the current Directory is Empty 
 *
 */
public class EmptyFolderException extends Exception{

	private static String logFilePath = "/Users/rahul/eclipse-workspace/Assignment2/src/p2/log.txt";
//	private static String logFilePath = "./"+log_fileName;

	private static final long serialVersionUID = 4527609849288368529L;

	
	public EmptyFolderException(File dname) throws IOException {
		FileWriter output = new FileWriter(logFilePath, true);
    	output.write("Error: Directory "+dname+" doesn't have any files!\n");
    	output.close();
		System.out.println("Error: Directory "+dname+" doesn't have any files!");
	}

}
