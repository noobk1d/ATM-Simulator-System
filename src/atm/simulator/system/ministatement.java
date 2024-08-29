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

public class ministatement extends JFrame implements ActionListener{
    JTable t1;
    JButton b1;
    String x[] = {"Customer Name","Date","Deposit","Withdraw","Balance"};
    String y[][] = new String[200][50];
    int i=0, j=0;
    
    ministatement(){
        super("Mini Statement");
        setSize(1200,650);
        setLocation(200,200);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from bank";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("created_at");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new ministatement().setVisible(true);
    }
    
}