package com.kreitek.store.application.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private Long userid;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Long phonenumber;


    public UsuarioDTO() {
    }


    public Long getId() {
        return userid;
    }

    public void setId(Long id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}
