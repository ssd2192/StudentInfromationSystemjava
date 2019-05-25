package term1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.MyConnection;

public class AddRecord {
	
	public boolean studentExist(int stuId){
        boolean d=false;
        try{
            Connection conn=MyConnection.OpenConnection();
            String query="select * from student where UPPER(StudentID)=UPPER(?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, stuId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                d=true;
            }
            else{
                d=false;
            }
        }
        catch(Exception e){
        }
        finally{
             MyConnection.closeConnection();
        }
        return d;
    }

	
	public boolean addStudent(int studentId, String fname, String lname, String major, String phone, float gpa, String dob) {
		boolean b = false;
		try{
            Connection conn=MyConnection.OpenConnection();
            String query="insert into Student(StudentId,FirstName,LastName,Major,Phone,GPA,DOB) values(?,?,?,?,?,?,?);";
         
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, major);
            ps.setString(5, phone);
            ps.setFloat(6, gpa);
            ps.setString(7, dob);
            int rs=ps.executeUpdate();
            
			if(rs>=1) {
                b=true;
            }
            else {
                b=false;
            }      
            ps.close();
            
        }
        catch(Exception e){
            System.out.println("Query error"+e.getMessage());
        }
        finally{
            MyConnection.closeConnection();
        }
		
		return b;
		
	}
	

}
