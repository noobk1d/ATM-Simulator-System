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
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b1,b2;
    JTextField t1,t2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    
    Signup3()
    {
        super("New Account Application Form - 3");
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Aieral",Font.BOLD,22));
        
        l2 = new JLabel("Account Type: ");
        l2.setFont(new Font("Aieral",Font.BOLD,18));
        
        l3 = new JLabel("Card Number: ");
        l3.setFont(new Font("Aieral",Font.BOLD,18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Aieral",Font.BOLD,18));
        
        l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Aieral",Font.BOLD,12));
        
        l6 = new JLabel("It would appear on ATM card/Cheque Book and Statements");
        l6.setFont(new Font("Aieral",Font.BOLD,12));
        
        l7 = new JLabel("PIN: ");
        l7.setFont(new Font("Aieral",Font.BOLD,18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Aieral",Font.BOLD,18));
        
        l9 = new JLabel("(4-Digit password)");
        l9.setFont(new Font("Aieral",Font.BOLD,12));
        
        l10 = new JLabel("Services Required: ");
        l10.setFont(new Font("Aieral",Font.BOLD,18)); 
        
        l11 = new JLabel("Form NO: ");
        l11.setFont(new Font("Aieral",Font.BOLD,12));
        
        l12 = new JLabel("Phone number: ");
        l12.setFont(new Font("Aieral",Font.BOLD,18));
       
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
            
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Aieral",Font.BOLD,16));
            
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Aieral",Font.BOLD,16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Aieral",Font.BOLD,16));
            
        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Aieral",Font.BOLD,16));
       
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Aieral",Font.BOLD,16));
            
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Aieral",Font.BOLD,16));
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Aieral",Font.BOLD,12));
        
        r1 = new JRadioButton("Savings Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Aieral",Font.BOLD,15));
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Aieral",Font.BOLD,15));
        
        r3 = new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Aieral",Font.BOLD,15));
        
        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Aieral",Font.BOLD,15));
        
        t1 =new JTextField();
        t2 =new JTextField();
        
        setLayout(null);
        
        l11.setBounds(700,10,70,30);
        add(l11);
        
        t1.setBounds(770,10,40,30);
        add(t1);
        
        l1.setBounds(280,50,400,40);
        add(l1); 
        
        l2.setBounds(100,130,200,30);
        add(l2);
        
        r1.setBounds(100,170,150,30);
        add(r1);
        
        r2.setBounds(350,170,300,30);
        add(r2);
        
        r3.setBounds(100,200,250,30);
        add(r3);
        
        r4.setBounds(350,200,250,30);
        add(r4);
        
        l12.setBounds(100,250,250,30);
        add(l12);
        
        l3.setBounds(100,300,200,30);
        add(l3);
        
        l4.setBounds(330,300,250,30);
        add(l4);
        
        l5.setBounds(100,330,200,20);
        add(l5);
        
        l6.setBounds(330,330,500,20);
        add(l6);
        
        l7.setBounds(100,370,200,30);
        add(l7);
        
        l8.setBounds(330,370,200,30);
        add(l8);
        
        l9.setBounds(100,400,200,20);
        add(l9);
        
        l10.setBounds(100,450,200,30);
        add(l10);
        
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7.setBounds(100,680,600,20);
        add(c7);
        
        b1.setBounds(300,720,100,30);
        add(b1);
        
        b2.setBounds(420,720,100,30);
        add(b2);
        
        t2.setBounds(330,250,200,30);
        add(t2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
            
    public void actionPerformed(ActionEvent ae)
    {
        String a="";
        if(r1.isSelected())
        {
            a = "Savings Account";
        }
        else if(r2.isSelected())
        {
            a = "Fixed Deposit Account";
        }
        else if(r3.isSelected())
        {
            a = "Current Account";
        }
        else if(r4.isSelected())
        {
            a = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L)+ 5040936000000000L;
        long first8 = Math.abs(first7);
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        long first4 = Math.abs(first3);
        
        String b="";
        if(c1.isSelected())
        {
            b = b+"ATM Card ";
        }
        if(c2.isSelected())
        {
            b = b+ "Internet Banking ";
        }
        if(c3.isSelected())
        {
            b = b+ "Mobile Banking ";
        }
        if(c4.isSelected())
        {
            b = b+ "Email Alerts ";
        }
        if(c5.isSelected())
        {
            b = b+ "Cheque Book ";
        }
        if(c6.isSelected())
        {
            b = b+ "E-Statement ";
        }
        
        String c =t1.getText();
        String d ="91"+t2.getText();
        int l = d.length();
        
        try{
            if(ae.getSource()==b1)
            {
                if(b.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the required fields");
                }
                else if(l<12)
                {
                    JOptionPane.showMessageDialog(null,"Enter correct mobile number");
                }
                else
                {
                    Conn c1 =new Conn();
                    Conn c2 = new Conn();
                    ResultSet rs = c2.s.executeQuery("select name from signup where id = '"+c+"'");
                    if(rs.next())
                    {
                    String name= rs.getString("name");
                    String q1 = "insert into signup3 values('"+a+"','"+first8+"','"+first4+"','"+b+"','"+c+"','"+d+"')";
                    String q2 ="insert into login values('"+first8+"','"+first4+"')";
                    String q3 ="insert into bank(pin,deposit,withdraw,balance,Phnno,name) values('"+first4+"','0','0','0','"+d+"','"+name+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+ first8 + "\n Pin: "+ first4);
                    
                    
                    String apiKey = "apikey=" + "";
                    String message = "&message=" + "Card number: "+first8+"\n"+"Pin: "+first4;
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + d;
			
			// Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                            JOptionPane.showMessageDialog(null, "Sucessfull registered");
                      }
                    rd.close();
                    
                    
                    
                    new deposit().setVisible(true);
                    setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Enter Correct form number");
                        setVisible(true);
                    }
                }
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
        }catch(Exception ex)
        {
            //JOptionPane.showInternalMessageDialog(null, e);
            ex.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Signup3().setVisible(true);
        
    }
}

