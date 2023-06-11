package com.kreitek.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String username;
    @Column(nullable = false, length = 40)
    @Size(min = 3, max = 40)
    private String name;
    @Column(length = 40)
    @Size(min = 3, max = 40)
    private String lastname;
    @Column(nullable = false, length = 40)
    @Size(min = 3, max = 40)
    private String email;
    @Column(nullable = false, length = 20)
    @Size(min = 8, max = 20)
    private String password;
    @Column(length = 9)
    private Long phonenumber;

    public Usuario() {
    }

    public Usuario(Long id, String username, String name, String lastname, String email, String password, Long phonenumber) {
        this.userid = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
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
}
