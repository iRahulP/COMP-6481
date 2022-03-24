package p2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author rahul
 * Sales Database class with facilitates the file processing for the Sales class and logging the same.
 *
 */
public class SalesDatabase {
	
	private static Sales[] salesArr = new Sales[50];
	private static List<File> files = new ArrayList<>();
	private static String log_fileName = "log.txt";
	private static String logFilePath = "/Users/rahul/eclipse-workspace/Assignment2/src/p2/"+log_fileName;
//	private static String logFilePath = "./"+log_fileName;
	private static String outputFilePath = "/Users/rahul/eclipse-workspace/Assignment2/src/p2/output.txt";
//	private static String outputFilePath = "./output.txt";
	private static Sales s;
	private static int seqCount;
	private static int binCount;
	private static int totalRecords;

	/**
	 * 
	 * @param sale
	 * @throws DuplicateRecordException
	 */
	public static void addRecords(Sales sale) throws DuplicateRecordException{
		try {
			for(int i = 0; i < salesArr.length; i++) {
				if(salesArr[i] != null && salesArr[i].getOrder_ID() == sale.getOrder_ID()) {
					throw new DuplicateRecordException(sale);
				}
				if(salesArr[i] == null) {
					salesArr[i] = sale;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePath
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void addRecordsHelper(String filePath) throws ParseException, DuplicateRecordException {
		File f = new File(filePath);
		if(f.exists() && !f.isDirectory()) { 
		    System.out.println("Log file exists!");
		    
		    try (BufferedReader br = new BufferedReader(new FileReader(f)))
	        {
	            String line;
	            while ((line = br.readLine()) != null) {
	                if(!line.contains("directory:") && line.endsWith(".txt")) {
	                	File file = new File(line.substring(5));
	                            
	                	BufferedReader br2 = new BufferedReader(new FileReader(file));
	                 
	                        String st;
							while ((st = br2.readLine()) != null) {
	                        	s = new Sales();
								String[] data = st.split("\\s+");	
								
								s.setCountry(data[0]);
								
								s.setItem_type(data[1]);
								
								s.setOrder_priority(data[2].charAt(0));
								
								String pattern = "dd/MM/yyyy";
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
								Date date1 = simpleDateFormat.parse(data[3]);
								s.setOrder_date(date1);
								
								s.setOrder_ID(Long.parseLong(data[4]));
								
								Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(data[5]);  
								s.setShip_date(date2);
								
								s.setUnits_sold(Integer.parseInt(data[6]));
								
								s.setUnit_price(Float.parseFloat(data[7]));
								
								s.setUnit_cost(Float.parseFloat(data[8]));
								
								s.setRevenue(Double.parseDouble(data[9]));
								
								s.setTotal_cost(Double.parseDouble(data[10]));
								
								s.setTotal_profit(Double.parseDouble(data[11]));
								
								addRecords(s);
							}
						br2.close();
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}else {
			System.out.println("Log file doesn't exist!");
		}
	}
	
	/**
	 * writes all unique Sales records to the output.txt file
	 */
	private static void writeRecords() {

		try { 
			File f = new File(outputFilePath);			
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(f));
            for (Sales s : salesArr) {
            	if(s != null) {
            		
            		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
            		
                	String ss = s.getCountry().toString() + "\t"+
            				s.getItem_type().toString() + "\t"+
            				s.getOrder_priority() + "\t"+
            				dateFormat.format(s.getOrder_date()) + "\t"+
            				s.getOrder_ID() + "\t"+
            				dateFormat.format(s.getOrder_date()) + "\t"+
            				String.valueOf(s.getUnits_sold()) + "\t"+
            				String.valueOf(s.getUnit_price()) + "\t"+
            				String.valueOf(s.getUnit_cost()) + "\t"+
            				String.valueOf(s.getRevenue()) + "\t"+
            				String.valueOf(s.getTotal_cost()) + "\t"+
            				String.valueOf(s.getTotal_profit()) + "\n";

            	f_writer.write(ss);
            	}
            }
            f_writer.close();

        }
        catch (Exception e) {
            e.getStackTrace();
        }
	}
	
	/**
	 * Displays file contents of the provided file
	 * @param name Name of the file
	 * @throws IOException 
	 */
	public static void displayFileContents(String name) throws InvalidFileException, IOException {
		File file = new File(name);
		 
		if(!name.endsWith(".txt")) {
			throw new InvalidFileException(name);
		}else {
	        try (BufferedReader br = new BufferedReader(new FileReader(file)))
	        {
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line.strip());
	                
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }			
		}
	}
	
	/**
	 * 
	 * @author rahul
	 *
	 */
	public static class SalesComparator implements Comparator<Sales> {
	    @Override
	    public int compare(Sales s1, Sales s2) {
	        return (int) (s1.getOrder_ID() - s2.getOrder_ID());
	    }
	}
	
	/**
	 * Searches the record with binary search algorithm
	 * @param order_ID
	 * @return true if found else false
	 */
	public static boolean binarySaleSearch(long order_ID) {
//		Arrays.sort(salesArr, new SalesComparator());
		int idx = binarySearchHelper(salesArr, order_ID, 0, totalRecords - 1);
		if(idx >= 0 && idx < totalRecords) {
			System.out.println("Sales Order present at "+idx);
			return true;
		}else {
			System.out.println("Sales Order not found!");	
			return false;
		}
	}
	
	/**
	 * Binary search algorithm
	 * @param salesArr
	 * @param order_ID
	 * @param low
	 * @param high
	 * @return index value
	 */
	public static int binarySearchHelper( Sales[] salesArr, long order_ID, int low, int high) {
	    int index = (int)1e9;
	    binCount = 0;
	    while (low <= high) {
	        int mid = low  + ((high - low) / 2);
	        binCount++;
	        if (salesArr[mid].getOrder_ID() < order_ID) {
	            low = mid + 1;
	        } else if (salesArr[mid].getOrder_ID() > order_ID) {
	            high = mid - 1;
	        } else if (salesArr[mid].getOrder_ID() == order_ID) {
	            index = mid;
	            break;
	        }
	    }
	    
	    return index;
	}
	
	/**
	 * Searches the record in sequential way
	 * @param order_ID
	 * @return true if found else false
	 */
	public static boolean sequentialSaleSearch(long order_ID) {
//		Arrays.sort(salesArr, new SalesComparator());
		seqCount = 0;
		for(int i = 0 ;i < totalRecords; i++) {
			seqCount++;
			if(salesArr[i].getOrder_ID() == order_ID) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cleans Up logFile if already present
	 */
	public static void cleanFile() {
		try {
	    	File fileD = new File(logFilePath);
	    	fileD.delete();			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	/**
	 * Cleans up output file if already present
	 */
	public static void cleanFile2() {
		try {
	    	File fileD = new File(outputFilePath);
	    	fileD.delete();			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	/**
	 * Checks if directory is Empty
	 * @param directory directory Name
	 * @return true if Empty else false
	 */
	public static boolean isDirectoryEmpty(File directory) {  
	    String[] files = directory.list();
	    return files.length == 0;  
	}
	
	/**
	 * Recursively calls for directory structures and adds the paths to log.txt file
	 * @param dirName 
	 * @return list of type File
	 */
	public static List<File> listStructures(File dirName) throws EmptyFolderException{
        File[] fileList = dirName.listFiles();
        
        try {        	
            try (FileWriter output = new FileWriter(logFilePath, true)) {
				for (File file : fileList) {
					if (file.isDirectory()) {
						if(isDirectoryEmpty(file)) {
							throw new EmptyFolderException(file);
						}
				    	output.write("directory:"+file.toString()+"\n");
				        files.add(file);
				        listStructures(file);
				    }
					else if(file.isFile()) {
				        output.write("file:"+file.toString()+"\n");
				        files.add(file);
				    }
				}
				
				output.close();
			}
        }
        catch (Exception e) {
            e.getStackTrace();
        }
       
        return files;
    }
	
	/**
	 * SalesDatabase Driver
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		StringBuilder sb1 = new StringBuilder();
		sb1.append("What do you want to do?\n"
				+ "		(1) List files\n"
				+ "		(2) Process files\n"
				+ "		(3) Quit\n"
				+ "Please enter your choice >");		
		String s1 = sb1.toString();
		int choice;
		
		try {
			
			do {
				System.out.println(s1);
				choice = sc.nextInt();
			
				if(choice == 1) {
					File f = new File("/Users/rahul/eclipse-workspace/Assignment2/src/p2/Data");
					cleanFile();
					listStructures(f);
					displayFileContents(logFilePath);
				}
				else if(choice == 2) {
					addRecordsHelper(logFilePath);
					
					totalRecords = 0;
					for(Sales s : salesArr) {
						if(s != null) {
							totalRecords++;
						}
					}
					
					cleanFile2();
					
					System.out.println("Writing records to output.txt");
					writeRecords();
					
					displayFileContents(outputFilePath);
					
					System.out.println("Searching for record 685241162!");
					binarySaleSearch(685241162);
					sequentialSaleSearch(685241162);
					System.out.println("Total Iternations for finding record with sequential search: 685241162 were "+seqCount);
					System.out.println("Total Iternations for finding record with sequential search: 685241162 were "+binCount);
				
				}
				else if(choice == 3) {
					System.exit(0);
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}while(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
