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
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author ISHA MISTRY
 */
@Path("external")
public class ExternalController {
    
    @GET
    @Path("products")
    public JSONObject testExternalApi()
    {
        Client client = ClientBuilder.newClient();
        WebTarget target= client.target("https://dummyjson.com/products?limit=5");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        
        if(response.getStatus() == 200)
        {
            String responsebody = response.readEntity(String.class);
            ExternalService extservice = new ExternalService();
            extservice.makeData(responsebody);
            
        }
        return null;
    }
    
    @GET
    @Path("selectedProducts")
    public JSONObject sendselectedJSON()
    {
        Client client = ClientBuilder.newClient();
        String url = "https://dummyjson.com/products?limit=5";
        WebTarget target= client.target(url);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        
        if(response.getStatus() == 200)
        {
            String responsebody = response.readEntity(String.class);
            ExternalService extservice = new ExternalService();
            return extservice.selectData(responsebody,url);
            
        }
        return null;
    }
}


//https://api.escuelajs.co/api/v1/products