package com.example.anitamarin.adogtame.models;

/**
 * Created by Anita Marin on 25/05/2017.
 */

public class Users {
    String email, password, city, _id;
    Long id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String email, String password, String city) {
        this.email = email;
        this.password = password;
        this.city = city;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
