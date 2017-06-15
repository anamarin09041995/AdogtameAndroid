package com.example.anitamarin.adogtame;

import android.app.Application;

import com.example.anitamarin.adogtame.models.DaoMaster;
import com.example.anitamarin.adogtame.models.DaoSession;
import com.google.gson.Gson;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static Retrofit retrofit;
    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mascotas.db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();
        retrofit = new Retrofit.Builder().baseUrl("http://186.112.33.237:3000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
