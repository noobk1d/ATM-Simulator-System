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

public class Signup1 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2;
    JButton b;
    JComboBox c1,c2,c3;
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L; //to genrate a random 4 digit number 
    long first = Math.abs(first4); //to convert the random number to a positive value
    
    Signup1()
    {
        super("New Account Application Form");
        
        l1 = new JLabel("Application Form no."+first);
        l1.setFont(new Font("Aieral",Font.BOLD,38));
        
        l2 = new JLabel("Page 1:Personal Details");
        l2.setFont(new Font("Aieral",Font.BOLD,24));
        
        l3 = new JLabel("Name: ");
        l3.setFont(new Font("Aieral",Font.BOLD,24));
        
        l4 = new JLabel("Fathers's Name: ");
        l4.setFont(new Font("Aieral",Font.BOLD,24));
        
        l5 = new JLabel("Date of Birth: ");
        l5.setFont(new Font("Aieral",Font.BOLD,24));
        
        l6 = new JLabel("Date");
        l6.setFont(new Font("Aieral",Font.BOLD,15));
        
        l7 = new JLabel("Month");
        l7.setFont(new Font("Aieral",Font.BOLD,15));
        
        l8 = new JLabel("Year");
        l8.setFont(new Font("Aieral",Font.BOLD,15));
        
        l9 = new JLabel("Gender: ");
        l9.setFont(new Font("Aieral",Font.BOLD,24));
        
        l10 = new JLabel("Email Address: ");
        l10.setFont(new Font("Aieral",Font.BOLD,24)); 
        
        l11 = new JLabel("Address: ");
        l11.setFont(new Font("Aieral",Font.BOLD,24));
        
        l12 = new JLabel("City: ");
        l12.setFont(new Font("Aieral",Font.BOLD,24));
        
        l13 = new JLabel("Pin Code: ");
        l13.setFont(new Font("Aieral",Font.BOLD,24));
        
        l14 = new JLabel("State: ");
        l14.setFont(new Font("Aieral",Font.BOLD,24));
        add(l1);   
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        
        b = new JButton("Next");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        
        String date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        c1 = new JComboBox(date);
        c1.setBackground(Color.white);
        
        String Month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        c2 = new JComboBox(Month);
        c2.setBackground(Color.white);
        
        String Year[] = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};
        c3 = new JComboBox(Year);
        c3.setBackground(Color.white);
        
         setLayout(null);
            
            l1.setBounds(140, 20, 600, 40);
            add(l1);
            
            l2.setBounds(290, 70, 600, 30);
            add(l2);
            
            l3.setBounds(100, 140, 100, 30);
            add(l3);
            
            t1.setBounds(300, 140, 400, 30);
            add(t1);
            
            l4.setBounds(100, 190, 200, 30);
            add(l4);
            
            t2.setBounds(300, 190, 400, 30);
            add(t2);
            
            l5.setBounds(100, 240, 200, 30);
            add(l5);
            
            l6.setBounds(300, 240, 40, 30);
            add(l6);
            
            c1.setBounds(340, 240, 60, 30);
            add(c1);
            
            l7.setBounds(410, 240, 50, 30);
            add(l7);
            
            c2.setBounds(460, 240, 100, 30);
            add(c2);
            
            l8.setBounds(570, 240, 40, 30);
            add(l8);
            
            c3.setBounds(610, 240, 90, 30);
            add(c3);
            
            l9.setBounds(100,290,200,30);
            add(l9);
            
            r1.setBounds(300,290,60,30);
            add(r1);
            
            r2.setBounds(450,290,90,30);
            add(r2);
          
            l10.setBounds(100,340,200,30);
            add(l10);
            
            t3.setBounds(300,340,400,30);
            add(t3);
            
            l11.setBounds(100,390,200,30);
            add(l11);
            
            t4.setBounds(300,390,400,30);
            add(t4);
            
            l12.setBounds(100,440,200,30);
            add(l12);
        
            t5.setBounds(300,440,400,30);
            add(t5);
            
            l13.setBounds(100,490,200,30);
            add(l13);
        
            t6.setBounds(300,490,400,30);
            add(t6);
        
            l14.setBounds(100,540,200,30);
            add(l14);
        
            t7.setBounds(300,540,400,30);
            add(t7);
            
             b.setBounds(620,600,80,30);
            add(b);
        
            b.addActionListener(this); 
        
            getContentPane().setBackground(Color.WHITE);
        
            setSize(850,850);
            setLocation(500,90);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String a = t1.getText();
        String b = t2.getText();
        
        String ac = (String)c1.getSelectedItem();
        String bc = (String)c2.getSelectedItem();
        String cc = (String)c3.getSelectedItem();
        
        String d=null;
        if(r1.isSelected())
        {
            d="Male";
        }
        else if(r2.isSelected())
        {
            d="Female";
        }
        String e = t3.getText();
        String g = t4.getText();
        String h = t5.getText();
        String i = t6.getText();
        String j = t7.getText();
        
        try
        {
            if(t6.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "fill all the required fields");
            }else{
                
                Conn c1 = new Conn();
                 String q1 = "insert into signup values('"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+g+"','"+h+"','"+i+"','"+j+"','"+first+"')";
                c1.s.executeUpdate(q1);
                
                new Signup2().setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new Signup1().setVisible(true);
    }
}

    
    
