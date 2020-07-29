/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.dto;

/**
 *
 * @author hp
 */
public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String contact;
    private String password;
    private String cpassword;
   
    
    @Override
    public String toString() {
        return "  firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", contact=" + contact + ", password=" + password + ", cpassword=" + cpassword + '}';
    }
 

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

        
    
}
