package airline.management.system;

import com.formdev.flatlaf.FlatLightLaf;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    DefaultTableModel model;
    
    public static void main(String[] args){		 
	            try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            Logger.getLogger(Flight_Info.class.getName()).log(Level.SEVERE, null, ex);
        } 

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
              new  Flight_Info().setVisible(true);
            }
        });   
    }
    
    public Flight_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Times New Roman", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(0, 0, 0));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                
                
                
                 try {
                   String code = textField.getText();
                    
                     Connection con = conn.getConnection();
                    String sql = "select f_code,f_name,src,dst,capacity,class_code,class_name from flight where f_code = '"+code+"'";
		PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(); 
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
               
	
                
              
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
//	JLabel FlightCode = new JLabel("FLIGHT CODE");
//	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        FlightCode.setBounds(23, 220, 126, 14);
//	add(FlightCode);
//		
//	JLabel FlightName = new JLabel("FLIGHT NAME");
//        FlightName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	FlightName.setBounds(145, 220, 120, 14);
//	add(FlightName);
//		
//	JLabel Source = new JLabel("SOURCE");
//	Source.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	Source.setBounds(275, 220, 104, 14);
//	add(Source);
//		
//	JLabel Destination = new JLabel("DESTINATION");
//	Destination.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	Destination.setBounds(367, 220, 120, 14);
//	add(Destination);
//		
//		
//	JLabel Capacity = new JLabel("CAPACITY");
//	Capacity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	Capacity.setBounds(497, 220, 111, 14);
//	add(Capacity);
//		
//	JLabel ClassCode = new JLabel("CLASS CODE");
//	ClassCode.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	ClassCode.setBounds(587, 220, 120, 14);
//	add(ClassCode);
//		
//	JLabel ClassName = new JLabel("CLASS NAME");
//	ClassName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//	ClassName.setBounds(700, 220, 111, 14);
//	add(ClassName);
//		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}