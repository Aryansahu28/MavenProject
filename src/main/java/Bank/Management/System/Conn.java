package Bank.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection c;
    public Statement s;
    public Conn(){
        try {
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Aryansahu@471201");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}