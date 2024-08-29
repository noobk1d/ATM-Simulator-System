
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

public class Pin_change extends JFrame implements ActionListener{
    
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    
    Pin_change(){
        
        super("Pin Change");        
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD,35));
        
        l2 = new JLabel("CURRENT PIN : ");
        l2.setFont(new Font("System", Font.BOLD,19));
        
        l3 = new JLabel("NEW PIN : ");
        l3.setFont(new Font("System", Font.BOLD,19));
        
        l4 = new JLabel("RE-ENTER NEW PIN : ");
        l4.setFont(new Font("System", Font.BOLD,19)); 
        
         t1 = new JPasswordField();
         t1.setFont(new Font("Aieral", Font.BOLD, 22));
         
         t2 = new JPasswordField();
         t2.setFont(new Font("Aieral", Font.BOLD, 22));

         t3 = new JPasswordField();
         t3.setFont(new Font("Aieral", Font.BOLD, 22));
        
         b1 = new JButton("SAVE");
         b1.setFont(new Font("System", Font.BOLD,18));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         
         b2 = new JButton("BACK");
         b2.setFont(new Font("System", Font.BOLD,18));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         
         b1.addActionListener(this);
         b2.addActionListener(this);
         
         
         setLayout(null);
         
         l1.setBounds(220,130,800,60);
         add(l1);
         
         l2.setBounds(100,240,150,40);
         add(l2);
        
         l3.setBounds(100,300,150,40);
         add(l3);
        
         l4.setBounds(100,360,200,40);
         add(l4);
        
         t1.setBounds(310,240,310,40);
         add(t1);
         
         t2.setBounds(310,300,360,40);
         add(t2);
        
         t3.setBounds(310,360,360,40);
         add(t3);
        
         b1.setBounds(220,460,160,50);
         add(b1);
        
         b2.setBounds(400,460,160,50);
         add(b2);
         
         
         
         
         getContentPane().setBackground(Color.WHITE);
         
         setSize(800,800);
         setLocation(500,50);
         setVisible(true);
         
    }        
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            String c = t3.getText();
            
            
            
            if(ae.getSource()==b1){
                Conn c2 = new Conn();
                ResultSet rs = c2.s.executeQuery("select * from bank where pin = '"+a+"'");
                
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please Enter Current PIN");
                
                }
                if(t2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t3.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                if(t2.getText().equals(t3.getText()) && rs.next()){
                    
                    Conn c1 =new Conn();
                    
                    String q1 = "update bank set pin = '"+b+"' where pin = '"+a+"' ";
                    String q2 = "update login set pin = '"+b+"' where pin = '"+a+"' ";
                    String q3 = "update signup3 set pin = '"+b+"' where pin = '"+a+"' ";
                    
                   
                    String no = rs.getString("Phnno");
                   
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    
                    
                    String msg1 = "Old Pin: " + a;
                    String msg2 = "New Pin: " + b;
                    
                     String apiKey = "apikey=" + "";
                    String message = "&message=" + msg1 + "\n" + msg2;
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
                            JOptionPane.showMessageDialog(null, "Pin Change Successfull");
                      }
                    rd.close();
                    
                    
              
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
                }
                    
                    
                    
                    
                
            }else if(ae.getSource()==b2){
                
                new Transactions().setVisible(true);
                setVisible(false);
                
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    }

    
        
    
    public static void main(String[] args){
        new Pin_change().setVisible(true);
    }
}
    


