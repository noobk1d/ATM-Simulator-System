/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
        JLabel l1,l2,l3;
        JTextField t1;
        JPasswordField p1;
        JButton b1,b2;
        
        Login()
        {
            super("Automated Teller Machine");
            
            l1 = new JLabel("Welcome To ATM");
            l1.setFont(new Font("Osward",Font.BOLD, 38));
            
            l2 = new JLabel("Card NO : ");
            l2.setFont(new Font("Osward",Font.BOLD, 28));
            
            l3 = new JLabel("PIN : ");
            l3.setFont(new Font("Osward",Font.BOLD, 28));
            
            t1 = new JTextField(20);
            p1 = new JPasswordField(20);
            
            b1 = new JButton("Sign In");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            
            b2 = new JButton("SIGN UP");
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            
            setLayout(null);
            
            l1.setBounds(175, 50, 450, 200);
            add(l1);
            
            l2.setBounds(125, 150, 375, 200);
            add(l2);
            
            l3.setBounds(125, 225, 375, 200);
            add(l3);
            
            t1.setBounds(300, 235, 230, 30);
            add(t1);
            
            p1.setBounds(300, 310, 230, 30);
            add(p1);
            
            b1.setBounds(300, 400, 100, 30);
            add(b1);
            
            b2.setBounds(430, 400, 100, 30);
            add(b2);
            
            b1.addActionListener(this);
            b2.addActionListener(this);
            
            getContentPane().setBackground(Color.white);
            
            setSize(750,750);
            setLocation(500,200);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae)
        {
            try{
                Conn c1 = new Conn();
                String a = t1.getText();
                String b = p1.getText();
                String q = "Select * from login where cardno ='"+a+"' and pin='"+b+"'";
                ResultSet rs = c1.s.executeQuery(q);
                
                if(ae.getSource()==b1){
                    if(rs.next()){
                        new Transactions().setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                    }
                }
                else if(ae.getSource()==b2)
                {
                    new Signup1().setVisible(true);
                    setVisible(false);
                }
               
            }catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }
        
        public static void main(String[] args)
        {
            new Login().setVisible(true);
        }
}
