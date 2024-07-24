/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey.controller;
import com.mycompany.demojersey.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.simple.JSONObject;
/**
 *
 * @author ISHA MISTRY
 */
@Path("admin")
public class AdminController {
    
    AdminDAO admindao = new AdminDAO();
    User user = new User();
        
    @POST
    @Path("createuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(JSONObject userdetails)
    {
        System.out.println(userdetails.toString());
        
        Object uname = userdetails.get("uname");
        if(uname instanceof HashMap)
        {
            JSONObject unameo = new JSONObject();
            unameo.putAll((HashMap) uname);
            user.setFname(unameo.get("fname").toString());
            user.setMidname((String)unameo.get("midname"));
            user.setLname((String)unameo.get("lname"));
        }
        
        user.setUsername((String)userdetails.get("username"));
        user.setPassword((String)userdetails.get("password"));
        user.setRole(((BigDecimal)userdetails.get("role")).intValue());
        System.out.println("json-->"+user.toString());
        admindao.createUser(user);
    }
}
