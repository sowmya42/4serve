package com.example.a4serve;

import io.realm.Realm;
import io.realm.RealmObject;

public class Events extends RealmObject {
    private String  name;
    private int date;
    private int img;
    private boolean follow;
    public Events(String n, int d, int p){
        name = n;
        date = d;
        img = p;
        follow = false;
    }

    public Events(){

    }

    public int getImg(){
        return img;
    }
    public int getDate(){
        return date;
    }
    public String name(){
        return name;
    }
    public boolean getFollow() { return follow;}
    public boolean switchFollow() {follow = (!follow); return follow;}
}
