package com.example.anitamarin.adogtame.net;

/**
 * Created by Anita Marin on 13/06/2017.
 */

public class RegisterResponse extends SimpleResponse {

    boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
