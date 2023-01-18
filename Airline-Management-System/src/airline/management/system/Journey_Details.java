package airline.management.system;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
         try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Journey_Details.class.getName()).log(Level.SEVERE, null, ex);
        } 

        EventQueue.invokeLater(() -> {
            new  Journey_Details().setVisible(true);
         });   
    }
    
    public Journey_Details(){
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLACK);
	ReservationDetails.setFont(new Font("Times New Roman", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("PNR_NO");
	Pnrno.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Ticketid.setBounds(172, 270, 71, 20);
	add(Ticketid);
		
	Fcode = new JLabel("F_CODE");
	Fcode.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Fcode.setBounds(297, 270, 103, 20);
	add(Fcode);
		
	Jnydate = new JLabel("JNY_DATE");
	Jnydate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Jnydate.setBounds(390, 270, 94, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("JNY_TIME");
	Jnytime.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Jnytime.setBounds(494, 270, 83, 20);
	add(Jnytime);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Source.setBounds(613, 270, 94, 20);
	add(Source);
		
	Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	Destination.setBounds(717, 270, 94, 20);
	add(Destination);
        
	String[] items1 =  {"Lebanon", "China", "Russia", "United States","Australia","Saudi Arabia"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"United States", "turkey", "Lebanon", "Russia", "Australia","Saudi Arabia"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
         table.setBackground(Color.WHITE);
	table.setBounds(38, 310, 770, 130);
       	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                
                 try {
                   String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                     Connection con = conn.getConnection();
                    String sql = "select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src = '"+src+"' and dst = '"+dst+"'";
		PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(); 
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
                
               /*
		try{
                    
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    Object columnNames[] = {"pnr_no ","ticket_id "," f_code","  jny_date"," jny_time","source ", "destination"};
                    Object tbData[][] = {{"pnr_no ","ticket_id "," f_code","  jny_date"," jny_time","source ", "destination"}};
                    DefaultTableModel tbModel = new DefaultTableModel(tbData,columnNames);
                    table = new JTable(tbModel);
                    
                    Connection con = conn.getConnection();
                    String sql = "select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src = '"+src+"' and dst = '"+dst+"'";
                    Statement stmt = con.createStatement();
                   
                     //PreparedStatement pst = con.prepareStatement(sql);
                      //table.getModel();
                      
                      
           // Statement st = con.createStatement();
            //String sql = "select * from reservation where src = '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    tbModel.removeRow(0);
                    if(rs.next()){
                        String pnr_no = String.valueOf(rs.getInt("pnr_no"));
                        String ticket_id = String.valueOf(rs.getInt("ticket_id"));
                        String f_code = String.valueOf(rs.getInt("f_code"));
                        String jny_date = String.valueOf(rs.getDate("jny_date"));
                        String jny_time = String.valueOf(rs.getTime("jny_time"));
                        String source = rs.getString("src");
                        String destination = rs.getString("dst");
                        
                         
                       Object[] rows = new Object[]{pnr_no ,ticket_id , f_code,  jny_date, jny_time, source , destination};
                       
                        
                        //adding the data intothe table
                        tbModel.addRow(rows);
                        
                        //table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                        
                        
                    }					
                    
					
		}catch(Exception e){
                System.out.println(e.getMessage());
                }
*/
            }
	});
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
