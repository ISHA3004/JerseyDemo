/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

/**
 *
 * @author ISHA MISTRY
 */
public class ApplicationMasterDTO {
    private String email;
    private long contact;
    private int appl_id;
    private int paymentStatus,ipvStatus,esignStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getAppl_id() {
        return appl_id;
    }

    public void setAppl_id(int appl_id) {
        this.appl_id = appl_id;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getIpvStatus() {
        return ipvStatus;
    }

    public void setIpvStatus(int ipvStatus) {
        this.ipvStatus = ipvStatus;
    }

    public int getEsignStatus() {
        return esignStatus;
    }

    public void setEsignStatus(int esignStatus) {
        this.esignStatus = esignStatus;
    }

    @Override
    public String toString() {
        return "ApplicationMasterDTO{" + "email=" + email + ", contact=" + contact + ", paymentStatus=" + paymentStatus + ", ipvStatus=" + ipvStatus + ", esignStatus=" + esignStatus + '}';
    }
}
