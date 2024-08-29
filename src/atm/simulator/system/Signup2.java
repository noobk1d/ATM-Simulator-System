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

public class Signup2 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3;
    JRadioButton r1,r2,r3,r4;
    JButton b;
    JComboBox c1,c2,c3,c4,c5;
    Signup2()
    {
        super("New Account Application Form - 2");
        
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Aieral",Font.BOLD,22));
        
        l2 = new JLabel("Religion: ");
        l2.setFont(new Font("Aieral",Font.BOLD,18));
        
        l3 = new JLabel("Category: ");
        l3.setFont(new Font("Aieral",Font.BOLD,18));
        
        l4 = new JLabel("Income: ");
        l4.setFont(new Font("Aieral",Font.BOLD,18));
        
        l5 = new JLabel("Educational ");
        l5.setFont(new Font("Aieral",Font.BOLD,18));
        
        l11 = new JLabel("Qualification: ");
        l11.setFont(new Font("Aieral",Font.BOLD,18));
        
        l7 = new JLabel("PAN NUMBER: ");
        l7.setFont(new Font("Aieral",Font.BOLD,18));
        
        l8 = new JLabel("Aadhar Number: ");
        l8.setFont(new Font("Aieral",Font.BOLD,18));
        
        l9 = new JLabel("Senior Citizen: ");
        l9.setFont(new Font("Aieral",Font.BOLD,18));
        
        l10 = new JLabel("Existing Account: ");
        l10.setFont(new Font("Aieral",Font.BOLD,18)); 
        
        l12 = new JLabel("Form NO: ");
        l12.setFont(new Font("Aieral",Font.BOLD,12));
        
        
        l6 = new JLabel("Occupation: ");
        l6.setFont(new Font("Aieral",Font.BOLD,18));
        
        
        b = new JButton("Next");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        
        r1 = new JRadioButton("Yes");
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("No");
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Yes");
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("No");
        r4.setBackground(Color.WHITE);
        
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
       
        
        String category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
     
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        
        setLayout(null);
        
        
        l12.setBounds(700,10,60,30);
        add(l12);
        
        
        
        t3.setBounds(760,10,60,30);
        add(t3);
        
        l1.setBounds(280,30,600,40);
        add(l1);
        
        l2.setBounds(100,120,100,30);
        add(l2);
        
        c1.setBounds(350,120,320,30);
        add(c1);
        
        l3.setBounds(100,170,100,30);
        add(l3);
        
        c2.setBounds(350,170,320,30);
        add(c2);
        
        l4.setBounds(100,220,100,30);
        add(l4);
        
        c3.setBounds(350,220,320,30);
        add(c3);
        
        l5.setBounds(100,270,150,30);
        add(l5);
        
        c4.setBounds(350,270,320,30);
        add(c4);
        
        l11.setBounds(100,290,150,30);
        add(l11);
        
        l6.setBounds(100,340,150,30);
        add(l6);
        
        c5.setBounds(350,340,320,30);
        add(c5);
        
        l7.setBounds(100,390,150,30);
        add(l7);
        
        t1.setBounds(350,390,320,30);
        add(t1);
        
        l8.setBounds(100,440,180,30);
        add(l8);
        
        t2.setBounds(350,440,320,30);
        add(t2);
        
        l9.setBounds(100,490,150,30);
        add(l9);
        
        r1.setBounds(350,490,100,30);
        add(r1);
        
        r2.setBounds(460,490,100,30);
        add(r2);
        
        l10.setBounds(100,540,180,30);
        add(l10);
        
        r3.setBounds(350,540,100,30);
        add(r3);
        
        r4.setBounds(460,540,100,30);
        add(r4);
        
        b.setBounds(570,600,100,30);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String a = (String)c1.getSelectedItem();
        String b = (String)c2.getSelectedItem();
        String c = (String)c3.getSelectedItem();
        String d = (String)c4.getSelectedItem();
        String e = (String)c5.getSelectedItem();
        String f = t1.getText();
        String g = t2.getText();
        String h = "";
        if(r1.isSelected()){
            h ="Yes";
        }
        else if(r2.isSelected()){
            h ="No";
        }
        String i ="";
        if(r3.isSelected()){
            i ="Yes";
        }
        else if(r4.isSelected()){
            i ="No";
        }
        String j=t3.getText();
        try{
            if(t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"All fields are requires");
            }
            else
            {
                Conn c2 = new Conn();
                ResultSet rs = c2.s.executeQuery("select name from signup where id = '"+c+"'");
                if(rs.next())
                 {
                Conn c1 =new Conn();
                String q1 = "insert into signup2 values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
                c1.s.executeUpdate(q1);
                new Signup3().setVisible(true);
                setVisible(false);
            }
                else
                {
                    JOptionPane.showMessageDialog(null, "Enter Correct form number");
                    setVisible(true);
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
     public static void main(String[] args)
    {
        new Signup2().setVisible(true);
    }
}
