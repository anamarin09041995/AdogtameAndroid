package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Users;

/**
 * Created by Anita Marin on 13/06/2017.
 */

public class SimpleResponse {

    boolean success;
    Users user;
    String msg;

    public Users usersget(){
        return user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
