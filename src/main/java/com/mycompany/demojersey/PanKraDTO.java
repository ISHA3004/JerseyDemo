/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;
import java.sql.Date;
/**
 *
 * @author ISHA MISTRY
 */
public class PanKraDTO {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String pan_card;
    private Date dob;
    private int referral_code;
    private String updated_by_whom;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPan_card() {
        return pan_card;
    }

    public void setPan_card(String pan_card) {
        this.pan_card = pan_card;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getReferral_code() {
        return referral_code;
    }

    public void setReferral_code(int referral_code) {
        this.referral_code = referral_code;
    }

    public String getUpdated_by_whom() {
        return updated_by_whom;
    }

    public void setUpdated_by_whom(String updated_by_whom) {
        this.updated_by_whom = updated_by_whom;
    }
    
}
