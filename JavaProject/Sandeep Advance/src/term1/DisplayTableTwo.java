package term1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.MyConnection;

public class DisplayTableTwo {
	
	private Connection con;

	public DisplayTableTwo(Connection con) {
		this.con = con;
	}

	public JTable getTableDisplay(String table,String query)throws Exception{
    	
        JTable table2=new JTable();
        DefaultTableModel dm=new DefaultTableModel();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
        
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }

        Object row[]=new Object[cols];
        while(rs.next()){
             for(int i=0;i<cols;i++){
                    row[i]=rs.getString(i+1);
                }
            dm.addRow(row);
        }
        table2.setModel(dm);
        return table2;
    }
    
	
    public void frameTwo(String table, String query) throws Exception {
    	JFrame f=new JFrame("Display Data");
         term1.DisplayTableTwo obj = new term1.DisplayTableTwo(MyConnection.OpenConnection());
         JScrollPane sp=new JScrollPane(obj.getTableDisplay("student", query));
         f.add(sp);
         f.setBounds(200,200,400,300);
         f.setVisible(true);
    }

}
