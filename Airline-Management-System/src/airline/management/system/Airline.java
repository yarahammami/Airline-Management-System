package airline.management.system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Airline extends JFrame {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
         try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
        } 

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
              new  Airline().setVisible(true);
            }
        });
        
    }

    public Airline() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("MY LOGIN");
        frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 21));
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 866, 452);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblLogin.setBounds(320, 138, 200, 25);
        frame.getContentPane().add(lblLogin);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblPassword.setBounds(280, 217, 100, 25);
        frame.getContentPane().add(lblPassword);

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        btnOk.setBounds(450, 296, 80, 25);
        frame.getContentPane().add(btnOk);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(btnOk);

        textField = new JTextField();
        textField.setBounds(400, 138, 189, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 217, 189, 25);
        frame.getContentPane().add(passwordField);

        Label label = new Label("LOGIN FORM");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        label.setBounds(350, 10, 413, 44);
        frame.getContentPane().add(label);


        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Mainframe();
            }
        });

        frame.setSize(960, 586);
        frame.setVisible(true);
    }
}
