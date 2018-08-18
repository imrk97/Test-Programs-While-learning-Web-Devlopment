
package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DataInsert {
    public static void Insert() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
           	Connection con=DriverManager.getConnection(url, "rohan", "rohan");
            String insert="insert into student values(?,?,?,?,?)";
            PreparedStatement ps1=con.prepareCall(insert);
            
            @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
            System.out.println("Enter the following values to Insert in the table!");
            System.out.println("Roll No. ::");
            int roll=sc.nextInt();
            System.out.println("Name ::");
            String name= sc.next(); 
            System.out.println("Address ::");
            String address=sc.next();
            System.out.println("Age :: ");
            int age=sc.nextInt();
            System.out.println("Marks ::");
            double marks=sc.nextDouble(); 
            
            ps1.setInt(1, roll);
            ps1.setString(2, name);
            ps1.setString(3, address);
            ps1.setInt(4, age);
            ps1.setDouble(5, marks);
            
            int i=ps1.executeUpdate();
            if(i>0){
            	System.out.println("Data inserted!!");
            }
        }catch(Exception e) {
        	System.out.println(e);
        	
        	
        }
    }
    
    
    public static void Update() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
           	Connection con=DriverManager.getConnection(url, "rohan", "rohan");
            String update="update student set marks=? where roll=?";
            PreparedStatement ps2=con.prepareCall(update);
            
            @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
            System.out.println("Enter the following values to Update the table!");
            System.out.println("Roll No. ::");
            int roll=sc.nextInt();
            System.out.println("Marks ::");
            double marks=sc.nextDouble(); 
            
            ps2.setDouble(1, marks);
            ps2.setInt(2, roll);
            
            
            
            int j=ps2.executeUpdate();
           if(j>0){
            	System.out.println("Data Updated!!");
            }
        }catch(Exception e) {
        	System.out.println(e);
        	
        	
        }
    }
    
    
    /*public static void delete() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
           	Connection con=DriverManager.getConnection(url, "rohan", "rohan");
            String insert="insert into student values(?,?,?,?,?)";
            PreparedStatement ps1=con.prepareCall(insert);
            
            @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
            System.out.println("Enter the following values to Insert in the table!");
            System.out.println("Roll No. ::");
            int roll=sc.nextInt();
            System.out.println("Name ::");
            String name= sc.next(); 
            System.out.println("Address ::");
            String address=sc.next();
            System.out.println("Age :: ");
            int age=sc.nextInt();
            System.out.println("Marks ::");
            double marks=sc.nextDouble(); 
            
            ps1.setInt(1, roll);
            ps1.setString(2, name);
            ps1.setString(3, address);
            ps1.setInt(4, age);
            ps1.setDouble(5, marks);
            
            int i=ps1.executeUpdate();
            while(i>0){
            	System.out.println("Data inserted!!");
            }
        }catch(Exception e) {
        	System.out.println(e);
        	
        	
        }
    }
    
}*/
    public static void Display() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
           	Connection con=DriverManager.getConnection(url, "rohan", "rohan");
            String display="select * from student";
            PreparedStatement ps3=con.prepareCall(display);
           
          ps3.executeUpdate();
           
        }catch(Exception e) {
        	System.out.println(e);
        	
        	
        }
    }
    
    public static void Delete() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
           	Connection con=DriverManager.getConnection(url, "rohan", "rohan");
            String delete="delete from student where roll=?";
            PreparedStatement ps4=con.prepareCall(delete);
            System.out.println("Enter roll:: ");
            Scanner sc=new Scanner(System.in);
            
            int roll= sc.nextInt();
            
           ps4.setInt(1, roll);
          int i=ps4.executeUpdate();
           if(i>0) {
        	   System.out.println("Details of "+roll+" Roll No. deleted.");
           }
        }catch(Exception e) {
        	System.out.println(e);
        	
        	
        }
    }
    
    
    public static void main(String[] args) {
		int ch;
		 Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("!!TABLE FOR STUDENT DETAILS!!");
			 System.out.println("Please choose");
	            System.out.println("1. Insert into Table");
	            System.out.println("2. Update Marks via Roll No");
	            System.out.println("3. delete from Table using Roll No.");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice:: ");
	         
	            
	            ch= sc.nextInt();
	            
	            switch(ch) {
	            case 1:
	            	Insert();
	            	break;
	            	
	            case 2:
	            	Update();
	            	break;
	           case 3:
	            	Delete();
	            	break;
	            	
	            case 4:
	            	System.exit(0);
	            default :
	            	System.out.println("PLEASE CHOOSE THE CORRECT OPTION!!");
	            	break;
	            }
		}
	}
    
}
