package com.example.changingactivities;

import android.app.Application;

public class App extends Application {
    private static App sInstance;

    public static App getInstance() {
        return sInstance;
    }

    private StudentsManager studentsManager;

    @Override
    public void onCreate() {
       super.onCreate();
       sInstance = this;
       studentsManager = new StudentsManager();
    }

    public StudentsManager getStudentsManager(){
        return studentsManager;
    }

}
