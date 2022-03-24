package p2;

import java.io.FileWriter;

/**
 * 
 * @author rahul
 *
 */
public class DuplicateRecordException extends Exception{
	private static String logFilePath = "/Users/rahul/eclipse-workspace/Assignment2/src/p2/log.txt";
//	private static String logFilePath = "./"+log_fileName;
	
	private static final long serialVersionUID = 7295088051349930500L;

	public DuplicateRecordException(Sales sale) throws Exception{
		duplicateRecordException(sale);
	}
	
	private void duplicateRecordException(Sales sale) throws Exception {
		FileWriter output = new FileWriter(logFilePath, true);
    	output.write("Duplicate Record "+sale+" found Exception!\n");
    	output.close();
		throw new Exception("Duplicate Record "+sale+" Found: -1");
	}
	
}
