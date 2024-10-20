/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

/**
 *
 * @author ADMIN
 */
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public abstract class AbstractDao {
    
    public  Connection connect() throws Exception {
        
      Class.forName("com.mysql.cj.jdbc.Driver");
     
        String url = "jdbc:mysql://localhost:3306/resume";
        String username ="root";
        String password ="12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    
}
