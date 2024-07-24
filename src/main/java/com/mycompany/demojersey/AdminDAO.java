/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author ISHA MISTRY
 */
public class AdminDAO {
    
    Connection conn = null;
    public AdminDAO(){
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
            System.out.println("Class not found "+e);
        }
    }
    
    public String getToken(Admin adminobj){
        String sql = "select token from user_admin_login where username=? and password=?";
        String token = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,adminobj.getUsername());
            ps.setString(2,adminobj.getPassword());
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                token = rs.getString(1);
            } 
            return token;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;   
    }
    
    public String updateCustomer(Admin admin,Customer cust){
        
       String token = getToken(admin);
       if(token.equals(admin.getToken()))
       {
           String sql = "update user_admin_login set password=? where application_id=?";
           try{
               PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,cust.getPassword());
                ps.setInt(2,cust.getApplicationId());
                ps.executeUpdate();
                return "Update successfull";
           }
           catch(Exception e){
               System.out.println(e);
           }
       }
       return "Authorization not done";
    }
    
    public void createUser(User user)
    {
        String sql = "insert into admin_user_details(fname,midname,lname,username,password,role) values(?,?,?,?,?,?)";
        try
        {
            int ind = 1;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(ind++,user.getFname());
            ps.setString(ind++,user.getMidname());
            ps.setString(ind++,user.getLname());
            ps.setString(ind++,user.getUsername());
            ps.setString(ind++,user.getPassword());
            ps.setInt(ind++,user.getRole());
            
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void getPanName(PanKraDTO pkdto)
    {
        String checksql = "select * from pankra where pannum = ?";
        try
        {
            int ind=1;
            PreparedStatement ps = conn.prepareStatement(checksql);
            ps.setString(ind++,pkdto.getPan_card());
            ps.executeQuery();
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String updsql = "update pankra set fname=?, midname=?,lname=?,pannum=?,dob=?,referral_code=?,updated_by_whom=?";
                try{
                    ind =1;
                    PreparedStatement psu = conn.prepareStatement(updsql);
                    psu.setString(ind++,pkdto.getFirst_name());
                    psu.setString(ind++,pkdto.getMiddle_name());
                    psu.setString(ind++,pkdto.getLast_name());
                    psu.setString(ind++,pkdto.getPan_card());
                    psu.setDate(ind++,pkdto.getDob());
                    psu.setInt(ind++, pkdto.getReferral_code());
                    psu.setString(ind++,pkdto.getUpdated_by_whom());
                    
                    psu.executeUpdate();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else
            {
                String insql = "insert into pankra values(?,?,?,?,?,?,?)";
                try{
                    ind =1;
                    PreparedStatement psu = conn.prepareStatement(insql);
                    psu.setString(ind++,pkdto.getFirst_name());
                    psu.setString(ind++,pkdto.getMiddle_name());
                    psu.setString(ind++,pkdto.getLast_name());
                    psu.setString(ind++,pkdto.getPan_card());
                    psu.setDate(ind++,pkdto.getDob());
                    psu.setInt(ind++, pkdto.getReferral_code());
                    psu.setString(ind++,pkdto.getUpdated_by_whom());
                    
                    psu.executeUpdate();
                }
                catch(Exception e)
                {
                    System.out.println("Insert kra"+e);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void insertUserAM(ApplicationMasterDTO amdto)
    {
        String sql = "insert into application_master(contact,email,payment_status,ipv_status,esign_status) values(?,?,?,?,?)";
        try{
            int ind=1;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(ind++,amdto.getContact());
            ps.setString(ind++,amdto.getEmail());
            ps.setInt(ind++,amdto.getPaymentStatus());
            ps.setInt(ind++,amdto.getIpvStatus());
            ps.setInt(ind++,amdto.getEsignStatus());
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public List<ApplicationMasterDTO> signedClients()
    {
        List<ApplicationMasterDTO> list = new ArrayList<>();
        String sql = "select appl_id,email,contact from application_master where esign_status=1";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ApplicationMasterDTO amdto = new ApplicationMasterDTO();
                amdto.setAppl_id(rs.getInt(1));
                amdto.setEmail(rs.getString(2));
                amdto.setContact(rs.getLong(3));
                
                list.add(amdto);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }
}
