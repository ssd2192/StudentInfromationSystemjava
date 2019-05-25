package term1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import connection.MyConnection;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
		
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 888, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 872, 558);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel heading = new JLabel("STUDENT INFORMATION PROJECT");
		heading.setForeground(new Color(0, 0, 255));
		heading.setBackground(UIManager.getColor("Tree.dropLineColor"));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(171, 11, 414, 23);
		panel.add(heading);
		
		JLabel lblStudentID = new JLabel("Student ID");
		lblStudentID.setBounds(27, 77, 78, 14);
		panel.add(lblStudentID);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(27, 102, 78, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(27, 127, 79, 14);
		panel.add(lblLastName);
		
		JLabel lblMajor = new JLabel("Major");
		lblMajor.setBounds(27, 152, 78, 14);
		panel.add(lblMajor);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(27, 178, 78, 14);
		panel.add(lblPhone);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setBounds(27, 203, 78, 14);
		panel.add(lblGpa);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(27, 228, 78, 14);
		panel.add(lblDateOfBirth);
		
		textField = new JTextField();
		textField.setBounds(131, 74, 170, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 99, 170, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 124, 170, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 149, 170, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 175, 170, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(131, 200, 170, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(131, 225, 170, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if(!textField.getText().equals("") && !textField_1.getText().equals("") 
						&& !textField_2.getText().equals("") && !textField_3.getText().equals("")
						&& !textField_4.getText().equals("") && !textField_5.getText().equals("")
						&& !textField_6.getText().equals("")) {
						int stuId = Integer.parseInt(textField.getText());
						String fname = textField_1.getText();
						String lname = textField_2.getText();
						String major = textField_3.getText();
						String phone = textField_4.getText();
						float gpa = Float.parseFloat(textField_5.getText());
						String dob = textField_6.getText();
					
						
						AddRecord add= new AddRecord();
						boolean d = add.studentExist(stuId);
						if(d) {
							JOptionPane.showMessageDialog(frame, "Student Already Exist");
						}
						else {
							boolean b = add.addStudent(stuId, fname, lname, major, phone, gpa, dob);
							if(b) {
								JOptionPane.showMessageDialog(frame, "Record Ented Successfully");
							}
						}
						
					}
					else {
						JOptionPane.showMessageDialog(frame," Empty Text Fields");
					}
				
				
			}
		});
		btnAdd.setBounds(27, 273, 112, 23);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!textField.getText().equals("") && !textField_1.getText().equals("") 
						&& !textField_2.getText().equals("") && !textField_3.getText().equals("")
						&& !textField_4.getText().equals("") && !textField_5.getText().equals("")
						&& !textField_6.getText().equals("")) {
						int stuId = Integer.parseInt(textField.getText());
						String fname = textField_1.getText();
						String lname = textField_2.getText();
						String major = textField_3.getText();
						String phone = textField_4.getText();
						float gpa = Float.parseFloat(textField_5.getText());
						String dob = textField_6.getText();
					
						
						UpdateRecord update= new UpdateRecord();
						boolean d = update.studentNotExist(stuId);
						if(!d) {
							JOptionPane.showMessageDialog(frame, "Student Does not Exist");
						}
						else {
							boolean b = update.updateStudent(stuId, fname, lname, major, phone, gpa, dob);
							if(b) {
								JOptionPane.showMessageDialog(frame, "Record Udated Successfully");
							}
						}
						
					}
					else {
						JOptionPane.showMessageDialog(frame," Empty Text Fields");
					}
				
				
				
			}
		});
		btnUpdate.setBounds(146, 273, 112, 23);
		panel.add(btnUpdate);
		
		JButton btnDisplayRecords = new JButton("DISPLAY RECORDS");
		btnDisplayRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DisplayTableTwo disp = new DisplayTableTwo(MyConnection.OpenConnection());
					disp.frameTwo("student","select * from student");
					} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					MyConnection.closeConnection();
				}
				
			}
		});
		btnDisplayRecords.setBounds(27, 307, 230, 23);
		panel.add(btnDisplayRecords);
		
		JButton btnSortByFirst = new JButton("SORT BY FIRST NAME");
		btnSortByFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DisplayTableTwo sortFirst = new DisplayTableTwo(MyConnection.OpenConnection());
					sortFirst.frameTwo("student","select * from student order by FirstName");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					MyConnection.closeConnection();
				}
			}
		});
		btnSortByFirst.setBounds(27, 341, 230, 23);
		panel.add(btnSortByFirst);
		
		JButton btnSortByLast = new JButton("SORT BY LAST NAME");
		btnSortByLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DisplayTableTwo sortLast = new DisplayTableTwo(MyConnection.OpenConnection());
					sortLast.frameTwo("student","select * from student order by LastName");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					MyConnection.closeConnection();
				}
				
			}
		});
		btnSortByLast.setBounds(27, 375, 230, 23);
		panel.add(btnSortByLast);
		
		JButton btnSortMajor = new JButton("SORT BY MAJOR");
		btnSortMajor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DisplayTableTwo sortMajor = new DisplayTableTwo(MyConnection.OpenConnection());
					sortMajor.frameTwo("student", "select * from student order by Major");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				finally {
					MyConnection.closeConnection();
				}
				
			}
		});
		btnSortMajor.setBounds(27, 409, 230, 23);
		panel.add(btnSortMajor);
		
		JButton btnSearchId = new JButton("Search");
		btnSearchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!textField_7.getText().equals("")) {
					
					try {
						int searchID= Integer.parseInt(textField_7.getText());
						Search sid = new Search(MyConnection.OpenConnection());
						sid.frameTwo("student", "select * from student where StudentId = "+searchID, searchID);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					finally {
						MyConnection.closeConnection();
					}
					
					
				} else {
					
					JOptionPane.showMessageDialog(frame," Empty Text Fields");
				}
				
			}
		});
		btnSearchId.setBounds(374, 136, 230, 23);
		panel.add(btnSearchId);
		
		JLabel lblSearchByStudent = new JLabel("SEARCH BY STUDENT ID");
		lblSearchByStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchByStudent.setBounds(374, 78, 230, 23);
		panel.add(lblSearchByStudent);
		
		textField_7 = new JTextField();
		textField_7.setBounds(376, 104, 230, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblSearchByMajor = new JLabel("SEARCH BY MAJOR");
		lblSearchByMajor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchByMajor.setBounds(577, 184, 186, 22);
		panel.add(lblSearchByMajor);
		
		textField_8 = new JTextField();
		textField_8.setBounds(577, 215, 159, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnSearchByMajor = new JButton("Search");
		btnSearchByMajor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!textField_8.getText().equals("")) {
					
					try {
						String searchMajor= textField_8.getText();
						SearchString smajor = new SearchString(MyConnection.OpenConnection());
						smajor.frameTwo("student", "select * from student where Major = '"+searchMajor+"';", searchMajor);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					finally {
						MyConnection.closeConnection();
					}
					
				} else {
					JOptionPane.showMessageDialog(frame," Empty Text Fields");

				}				
				
			}
		});
		btnSearchByMajor.setBounds(577, 246, 160, 23);
		panel.add(btnSearchByMajor);
		
		JLabel lblSearchByLast = new JLabel("SEARCH BY LAST NAME");
		lblSearchByLast.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchByLast.setBounds(335, 187, 216, 19);
		panel.add(lblSearchByLast);
		
		textField_9 = new JTextField();
		textField_9.setBounds(335, 215, 189, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnSearchLastName = new JButton("Search");
		btnSearchLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!textField_9.getText().equals("")) {
					
					try {
						String searchLname= textField_9.getText();
						SearchString slname = new SearchString(MyConnection.OpenConnection());
						slname.frameTwo("student", "select * from student where LastName = '"+searchLname+"';", searchLname);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					finally {
						MyConnection.closeConnection();
					}
					
				} else {
					JOptionPane.showMessageDialog(frame,"Empty Text Fields");

				}
				
			}
		});
		btnSearchLastName.setBounds(335, 246, 190, 23);
		panel.add(btnSearchLastName);
	}
}
