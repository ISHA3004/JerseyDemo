package com.mycompany.demojersey;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import org.json.simple.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("user")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    CustomerDAO custdao = new CustomerDAO();
    AdminDAO admindao = new AdminDAO();
    
    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        System.out.println("Frontend connected");
        return "Hello isha mistry";
    }
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public void userLogin(Customer cust){
        System.out.println("hii "+cust.toString());
        custdao.createCustomer(cust);
        
    }
    
    @GET
    @Path("accessToken")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adminLogin(Admin admin){
        System.out.println("hii "+admin.toString());
        String token = admindao.getToken(admin);
        if(token == null)
           return "Wrong username or password - No token";
        else
           return token;
       // return "hello";
       
    }
    
    @PUT
    @Path("adminupdate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateAdmin(JSONObject updDetails){
        System.out.println("hii "+updDetails.toString());
        Admin admin = new Admin();
        Customer cust = new Customer();
        admin.setUsername((String)updDetails.get("username"));
        admin.setPassword((String)updDetails.get("password"));
        admin.setToken((String)updDetails.get("token"));
        //cust.setApplicationId((Integer)updDetails.get("applicationId"));
        cust.setApplicationId(((BigDecimal)updDetails.get("applicationId")).intValue());
        cust.setPassword((String)updDetails.get("updPassword"));
        
        return admindao.updateCustomer(admin,cust);
    }
    
}
