package writeCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class writeCSV {
	
	private String outputFile = "test.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		writeCSV obj = new writeCSV();
//		Scanner s = new Scanner(System.in);
//		System.out.println("enter r for read, w for write");
//		String str = s.nextLine();
//		
//		while(true)
//		{
//			if(str == "r")
//			{
//				obj.read();
//			}else if(str == "w")
//			{
//				obj.write();
//			}
//		}
		obj.write();
		obj.read();
		
		
		// before we open the file check to see if it already exists
		
		

	}
	
	public void write()
	{
		boolean alreadyExists = new File(outputFile).exists();
		
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("id");
				csvOutput.write("name");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write("0001");
			csvOutput.write("Kun");
			csvOutput.endRecord();
			
			csvOutput.write("0002");
			csvOutput.write("Hou");
			csvOutput.endRecord();
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read()
	{
		try {
			
			CsvReader products = new CsvReader("test.csv");
		
			products.readHeaders();

			while (products.readRecord())
			{
				String productID = products.get("id");
				String productName = products.get("name");
			
				
				// perform program logic here
				System.out.println(productID + ":" + productName);
			}
	
			products.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
