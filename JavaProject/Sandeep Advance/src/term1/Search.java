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

public class Search {
	
	private Connection con;

	/**
	 * 
	 * @param con
	 */
	
	public Search(Connection con) {
		this.con = con;
	}

	public JTable getTableDisplay(String table,String query, int key)throws Exception{
    	
        JTable table2=new JTable();
        DefaultTableModel dm=new DefaultTableModel();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }

        //get data from rows
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
    
    public void frameTwo(String table, String query, int key) throws Exception {
    	JFrame f=new JFrame("Display Data");
        // MyConnection.OpenConnection();
         term1.Search obj_search = new term1.Search(MyConnection.OpenConnection());
         JScrollPane sp=new JScrollPane(obj_search.getTableDisplay("student", query, key));
         f.add(sp);
         f.setBounds(200,200,400,300);
         f.setVisible(true);
    }

}
