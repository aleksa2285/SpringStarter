package com.spitter.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SPITTER_ID")
    private Long id;
    @NotNull
    @Size(min = 5, max = 30, message = "{username.size}")
    @Column(name="SPITTER_USERNAME")
    private String username;
    @NotNull
    @Size(min = 10, max = 40)
    @Column(name="SPITTER_EMAIL")
    private String email;
    @NotNull
    @Size(min = 6, max = 40, message = "{password.size}")
    @Column(name="SPITTER_PASSWORD")
    private String password;
    @Column(name="SPITTER_PROFILE_PICTURE")
    private String pathProfle;


    public Spitter(String email, String username, String password, String pathProfle) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.pathProfle = pathProfle;
    }

    public Spitter() {
    }

    public String getPathProfle() {
        return pathProfle;
    }

    public void setPathProfle(String pathProfle) {
        this.pathProfle = pathProfle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "lastname", "username", "password");
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "password" );
    }
}
