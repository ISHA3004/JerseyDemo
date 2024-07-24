/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

/**
 *
 * @author ISHA MISTRY
 */
public class User {
    private int userid;
    private String fname;
    private String midname;
    private String lname;
    private String username;
    private String password;
    private int role;
    
    public void setUserId(int userid)
    {
        this.userid = userid;
    }
    public void setFname(String fname)
    {
        this.fname = fname;
    }
    public void setMidname(String midname)
    {
        this.midname = midname;
    }
    public void setLname(String lname)
    {
        this.lname = lname;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setRole(int role)
    {
        this.role = role;
    }
    
    public int getUserId(){
        return userid;
    }
    public String getFname(){
        return fname;
    }   
    public String getMidname(){
        return midname;
    } 
    public String getLname(){
        return lname;
    } 
    public String getUsername(){
        return username;
    } 
    public String getPassword(){
        return password;
    } 
    public int getRole(){
        return role;
    } 
}
