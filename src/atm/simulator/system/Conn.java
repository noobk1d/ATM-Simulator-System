/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
    	Connection con = null;
            try{
            	Class.forName("oracle.jdbc.OracleDriver");
    			
    			String url = "jdbc:oracle:thin:@localhost:1521:XE";
    			String uname = "system";
    			String pass = "123456";
    			
    			
    			con = DriverManager.getConnection(url,uname,pass);
    			s=con.createStatement();
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
}
}