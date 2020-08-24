import java.lang.*;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;

public class file_handling_assignment {
	static File filee,filew,filen,files;
	static File employee_details;
	static File product_details;
	static int no_of_regions = 4;
	
	
	public static void main(String args[]) {
		create_employee_details();
		create_product_details();
		for(int i = 1; i<= no_of_regions; i++) {
			if(i==1) {
				create_file_details(filen);
			}
			else if (i==2) {
				create_file_details(files);
			}
			else if(i==3) {
				create_file_details(filee);
			}
			else if(i==4) {
				create_file_details(filew);
			}
		}
		
	}
	
	public static void create_file_details(File file) {
		try {
		FileWriter fw = new FileWriter(file);
		
		int no_of_salesmen = 6;
		
		for(int day = 1; day<=30; day++) {
			String s = "";
			for(int j =1; j<= no_of_salesmen; j++) {
				
				s = s+details_of_sale();
			}
			fw.write(s+"\n");
		}
		}
		catch(Exception e) {
			
		}
}

	public static void create_employee_details() {
		try {
		String emp = "C:/Users/HP/Desktop/DBMS assignment/employee_details_file.txt";
		employee_details = new File(emp);
		if(!employee_details.exists()) {
			employee_details.createNewFile();
		}
		
		FileWriter fw = new FileWriter(employee_details);
		for(int i =1; i<= no_of_regions; i++) {
			String region = "";
			if(i==1) {
				region = "N";
			}
			else if(i==2) {
				region = "S";
			}
			else if(i==3) {
				region = "E";
			}
			else if(i==4) {
				region = "W";
			}
					
			for(int j=0; j<6; j++) {
				String emp_details = region+"_"+j;
				fw.write(emp_details+"\n");
			}
		}
		}
		catch(Exception e) {
			
		}
		
	}

	public static void create_product_details() {
		
		try {
		int no_of_products = 4;
		String pd = "C:/Users/HP/Desktop/DBMS assignment/product_details_file.txt";
		product_details = new File(pd);
		FileWriter fwp = new FileWriter(product_details);
		Random rand = new Random();
		
		for(int i=1; i<= no_of_products; i++) {
			String product_name = "product-"+i;
			String product_id = "xyz0000"+i;
			double price = rand.nextDouble();
			fwp.write(product_name+","+product_id+","+price+"\n");
			}
		}
		catch(Exception e) {
			
		}
	}

	public static String details_of_sale() {
		String out = "";
		try{
			Random rand = new Random();
			Scanner fr = new Scanner(product_details);
			out = "[";
			while(fr.hasNextLine()) {
				String[] product_details = fr.nextLine().split(",");
				int sold_item = rand.nextInt(5);
				double total_price = sold_item*Double.parseDouble(product_details[2]);
				out = out+"("+product_details[1]+","+total_price+")"; 
			}
			out = out+"]";
				}
		catch(Exception e) {
			
		}
		return out;
	}
}
