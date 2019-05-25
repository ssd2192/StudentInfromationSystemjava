package term1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.MyConnection;

public class UpdateRecord {
	
	public boolean studentNotExist(int stuId){
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
	
	public boolean updateStudent(int studentId, String fname, String lname, String major, String phone, float gpa, String dob) {
		boolean b = false;
		try{
            Connection conn=MyConnection.OpenConnection();
            String query="update Student set FirstName =? ,LastName = ? ,Major =? ,Phone=? ,GPA =? ,DOB=? where StudentId =?;";
         
            PreparedStatement ps=conn.prepareStatement(query);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, major);
            ps.setString(4, phone);
            ps.setFloat(5, gpa);
            ps.setString(6, dob);
            ps.setInt(7, studentId);
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
