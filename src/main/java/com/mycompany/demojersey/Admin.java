/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

/**
 *
 * @author ISHA MISTRY
 */
public class Admin {
    private int applicationId;
    private String username;
    private String password;
    private String token;
    
    public void setApplicationId(int applicationId){
        this.applicationId = applicationId;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public int getApplicationId(){
        return applicationId;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getToken(){
        return token;
    }
    
    @Override
    public String toString(){
        return "Username : "+username+"Password : "+password;
    }
}
