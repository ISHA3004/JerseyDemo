/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey.controller;
import com.mycompany.demojersey.*;
import java.sql.Date;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author ISHA MISTRY
 */
@Path("kraverification")
public class RMController {
    
    AdminDAO admindao = new AdminDAO();
    
    @POST
    @Path("getPanName")
    @Consumes(MediaType.APPLICATION_JSON)
    public void getPanName(JSONObject userdetails)
    {
        PanKraDTO pankradto = new PanKraDTO();
        if(userdetails.containsKey("first_name"))
            pankradto.setFirst_name((String)userdetails.get("first_name"));
        
        if(userdetails.containsKey("middle_name"))
            pankradto.setMiddle_name((String)userdetails.get("middle_name"));
        
        if(userdetails.containsKey("last_name"))
            pankradto.setLast_name((String)userdetails.get("last_name"));
        
        if(userdetails.containsKey("pan_card"))
            pankradto.setPan_card((String)userdetails.get("pan_card"));
        
        if(userdetails.containsKey("dob"))
            pankradto.setDob(java.sql.Date.valueOf((String)userdetails.get("dob")));
        
        if(userdetails.containsKey("referral_code"))
            pankradto.setReferral_code(((BigDecimal)userdetails.get("referral_code")).intValue());
        
        if(userdetails.containsKey("updated_by_whom"))
            pankradto.setUpdated_by_whom((String)userdetails.get("updated_by_whom"));
        
        admindao.getPanName(pankradto);
    }
    
    @POST
    @Path("contactEmail")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertEmailContact(JSONObject logindet)
    {
        ApplicationMasterDTO apmdto = new ApplicationMasterDTO();
        apmdto.setEmail((String)logindet.get("email"));
        apmdto.setContact(((BigDecimal)logindet.get("contact")).longValue());
        apmdto.setPaymentStatus(((BigDecimal)logindet.get("payStatus")).intValue());
        apmdto.setIpvStatus(((BigDecimal)logindet.get("ipvStatus")).intValue());
        apmdto.setEsignStatus(((BigDecimal)logindet.get("esignStatus")).intValue());
        
        System.out.println(apmdto.toString());
        admindao.insertUserAM(apmdto);
    }
    
    @GET
    @Path("getSignedClient")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getSignedClient()
    {
        List<ApplicationMasterDTO> list = admindao.signedClients();
        JSONArray arr = new JSONArray();
        
        for(ApplicationMasterDTO amdto : list)
        {
            JSONObject client = new JSONObject();
            client.put("appl_id",amdto.getAppl_id());
            client.put("contact",amdto.getContact());
            client.put("email",amdto.getEmail());
            arr.add(client);
        }
        
        JSONObject clients = new JSONObject();
        clients.put("clients",arr);
        
        return clients;
    }
}
