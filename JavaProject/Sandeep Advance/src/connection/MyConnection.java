
package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    static Connection conn=null;
    public static Connection OpenConnection(){
        try{
        	 Class.forName("com.mysql.jdbc.Driver");
        	 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","");
        	 
        	 System.out.println("Connection Successfull");
        	 System.out.println(conn);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());   
        }
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            System.out.println("Connection Closed Successfully");
        }
        catch(Exception e){
            
        }
    } 
}
