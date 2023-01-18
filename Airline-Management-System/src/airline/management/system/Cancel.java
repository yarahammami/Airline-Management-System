package airline.management.system;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;


public class Cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
            try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            Logger.getLogger(Cancel.class.getName()).log(Level.SEVERE, null, ex);
        } 

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
              new  Cancel().setVisible(true);
            }
        });

    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PassengerNo = new JLabel("PASSENGER NO");
	PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	PassengerNo.setBounds(60, 100, 132, 26);
	add(PassengerNo);
		
	JLabel CancellationNo = new JLabel("CANCELLATION NO");
	CancellationNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationNo.setBounds(60, 150, 150, 27);
	add(CancellationNo);
		
	JLabel CancellationDate = new JLabel("CANCELLATION DATE");
	CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationDate.setBounds(60, 200, 180, 27);
	add(CancellationDate);
		
	JLabel Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Ticketid.setBounds(60, 250, 150, 27);
	add(Ticketid);
		
	JLabel Flightcode = new JLabel("FLIGHT_CODE");
	Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Flightcode.setBounds(60, 300, 150, 27);
	add(Flightcode);
		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	add(textField);
	
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	add(textField_3);
		
	textField_4 = new JTextField();
	textField_4.setBounds(250, 300, 150, 27);
	add(textField_4);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                int passenger_no = Integer.parseInt(textField.getText());
		int cancellation_no = Integer.parseInt(textField_1.getText());
		String cancellation_date = textField_2.getText();
		int ticket_id = Integer.parseInt(textField_3.getText());
		String flight_code = textField_4.getText();
                Date canc_date = null;
                
                try {
                     canc_date=new SimpleDateFormat("dd/MM/yyyy").parse(cancellation_date);
                } catch (ParseException ex) {
                    Logger.getLogger(Cancel.class.getName()).log(Level.SEVERE, null, ex);
                }
			long cancellationDate = canc_date.getTime();
                try {
                     java.sql.Date cancDate = new java.sql.Date(cancellationDate);
            Connection con = conn.getConnection();
            String sql = "insert into cancellation values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, passenger_no);
            pst.setInt(2, cancellation_no);
            pst.setDate(3, cancDate);
            pst.setInt(4, ticket_id);
            pst.setString(5, flight_code);
            
         
            
          int rowCount =   pst.executeUpdate();
          if(rowCount > 0){
              JOptionPane.showMessageDialog(null,"Ticket Canceled");
                }else{
              JOptionPane.showMessageDialog(null,"Ticket Not Canceled");
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
                		
					
		
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}
