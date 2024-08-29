/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;


public class Withdraw extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    
    Withdraw(){
        
        super("Withdraw");
        
        
        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setFont(new Font("System", Font.BOLD, 40));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setFont(new Font("System", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setFont(new Font("System", Font.BOLD, 35));
        
        l4 = new JLabel("Enter Pin");
        l4.setFont(new Font("System", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        l4.setBounds(620,10,80,30);
        add(l4);
        
        t2.setBounds(700,10,40,30);
        add(t2);
        
        l1.setBounds(90,100,800,60);
        add(l1);
        
        l2.setBounds(270,160,800,60);
        add(l2);
        
        l3.setBounds(120,260,800,60);
        add(l3);
        
        t1.setBounds(210,340,360,50);
        add(t1);
        
        b1.setBounds(220,400,160,50);
        add(b1);
        
        b2.setBounds(400,400,160,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw ");
                
                }else{
                    
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+b+"' order by created_at desc limit 1");
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        String no = rs.getString("Phnno");
                        balance = rs.getDouble("balance");
                        String name = rs.getString("name");
                        double d = Double.parseDouble(a);
                        balance-=d;
                        String q1= "insert into bank(pin,deposit,withdraw,balance,Phnno,name) values('"+pin+"',null,'"+d+"','"+balance+"','"+no+"','"+name+"')";
                    
                    String apiKey = "apikey=" + "";
                    String message = "&message=" + "Amount Withdrawn: " + d + "\n" + "Balance: " + balance;
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + no;
			
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
                            JOptionPane.showMessageDialog(null, "Sucessfull Withdrawn");
                      }
                    rd.close();
                        
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+a+" Withdrawn Successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Wrong Pin");
                    }
                    
                    
                    
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
                
            }else if(ae.getSource()==b2){
                
                new Transactions().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdraw().setVisible(true);
    }
}
