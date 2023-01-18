package airline.management.system;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener{
    
    TextField t1,t2;
    Label l1,l2;
    Button b2,b3,b4;
    GridBagLayout gbl;  
    GridBagConstraints gbc; 
    Font f1,f2;
    
     public static void main(String[] args){
             try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 

        EventQueue.invokeLater(() -> {
            new  Login().setVisible(true);
         });   
    }
    
    public Login(){
        super("Login");
                
        setBackground(Color.WHITE); 
        f1 = new Font("TimesRoman",Font.BOLD,20);
        f2 = new Font("TimesRoman",Font.BOLD,15);
		
        gbl=new GridBagLayout(); 
	gbc=new GridBagConstraints();
        setLayout(gbl); 
	
        l1 = new Label("Username");
        l1.setFont(f1);
	
        l2 = new Label("Password");
        l2.setFont(f1);

	
        t1 = new TextField(15); 
	t2 = new TextField(15); 
        t2.setEchoChar('*');
	
	b2 = new Button("Reset");
        b2.setFont(f2);
		
        b3 = new Button("Submit");
        b3.setFont(f2);
		
        b4 = new Button("Close");
	b4.setFont(f2);
		
        gbc.gridx=0;
	gbc.gridy=0; 
        gbl.setConstraints(l1,gbc);
	add(l1);
        
	gbc.gridx=2;
        gbc.gridy=0;
	gbl.setConstraints(t1,gbc);
        add(t1);
		
	gbc.gridx=0;
        gbc.gridy=2;
	gbl.setConstraints(l2,gbc);
        add(l2);

	gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(t2,gbc);
	add(t2);
				
	
	gbc.gridx=0;
        gbc.gridy=8;
	gbl.setConstraints(b2,gbc);
        add(b2);

        gbc.gridx=2;
	gbc.gridy=8;
        gbl.setConstraints(b3,gbc);
	add(b3);
	
        gbc.gridx=4;
	gbc.gridy=8;
        gbl.setConstraints(b4,gbc);
	add(b4);
        

        b2.addActionListener(this);
        b3.addActionListener(this);
	b4.addActionListener(this);
                
        setVisible(true);   
        setSize(400,250); 
        setLocation(400,200);   
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
          
            t1.setText("");  
            t2.setText(""); 
	}
        if(ae.getSource()==b4){
            System.exit(0); 
	}
        if(ae.getSource()==b3){
          
            try{
            Connection con = conn.getConnection();

                String s1 = t1.getText();
                String s2 = t2.getText();
            
                String sql = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(); 
                
                if(rs.next()){
                    new Mainframe();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false); 
                }
            
            }catch(Exception e){}
            
	}
    }        
   
   
}
