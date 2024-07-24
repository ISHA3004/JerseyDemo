/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ISHA MISTRY
 */
public class ExternalDAO {
    
    Connection conn=null;
    
    ExternalDAO()
    {
        String url = "jdbc:mysql://localhost:3306/externalapi";
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
    
    
    public void insertData(ExternalDTO extdto)
    {
        String sql = "insert into products(rating,thumbnail,weight,category,dimdepth,dimheight,dimwidth) values(?,?,?,?,?,?,?)";
       
        try{
            int pos=1;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(pos++,extdto.getRating());
            ps.setString(pos++,extdto.getThumbnail());
            ps.setInt(pos++,extdto.getWeight());
            ps.setString(pos++,extdto.getCategory());
            ps.setDouble(pos++,extdto.getDimDepth());
            ps.setDouble(pos++,extdto.getDimHeight());
            ps.setDouble(pos++,extdto.getDimWidth());
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void enterlogs(String strres,String url)
    {
        String sql = "insert into logsapi(api,response) values(?,?)";
        try
        {
            int pos=1;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(pos++,url);
            ps.setString(pos++,strres);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
