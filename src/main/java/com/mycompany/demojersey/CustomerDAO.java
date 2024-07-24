/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

/**
 *
 * @author ISHA MISTRY
 */
import java.sql.*;
public class CustomerDAO {
    
    Connection conn = null;
    public CustomerDAO(){
        String url = "jdbc:mysql://localhost:3306/phillipcapital";
        String username = "root";
        String password = "";
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            if(conn != null)
                System.out.println("Successfull Connection");
            else
                System.out.println("Connection failed");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
        }
    }
    
    public void createCustomer(Customer cust){
        String sql = "insert into user_admin_login(username,password,user_type) values(?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cust.getUsername());
            ps.setString(2,cust.getPassword());
            ps.setString(3,"Customer");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
