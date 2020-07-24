package com.galvanize.crud_checkpoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table (name = "user")

@JsonInclude(JsonInclude.Include.NON_NULL) //Removes returns that contain a null
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    @JsonIgnore //Does not print password in /all request
    private String password;

    public Long getId() { return id; }
    public void setId(Long id) {this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //Endpoint#1: GET /users
    //  Accepts POSTMAN GET Request returns list of all Users -> id & email
    /////// Complete

    //Endpoint#2: POST /users
    //Accept JSON from a the body of a POST -- Takes, Inserts to DB, & Displays Data
    /////// Complete

    //EndPoint #3: GET /users/{id}
    // Takes a URL GET param, Dispalys JSON where ID = user.ID
    //////////// Complete

    //EndPoint #4 PATCH /users/{id}
    // Takes a PATCH from postma /w URL param = id, updates DB, displays content updated.
    ////////////

    //End Point #5 DELETE /users/{id}
    // Takes DELETE with URL Param = id, removes data from DB where param.id = user.id; retuns the # of remaining users
    ///////////////  Complete


    //EndPoint #6 /users/authenticate
    // Takes POST request BODY /w email & password, SELECT * from DB where post.email=user.email,
    // IF post.password = user.password, true -> return user data :: false -> return "authenticated": false
    //////////////////

}


