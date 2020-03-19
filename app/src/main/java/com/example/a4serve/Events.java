package com.example.a4serve;

import io.realm.Realm;
import io.realm.RealmObject;

public class Events extends RealmObject{
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

    public void storeEvents() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Events events = new Events(name, date, img);

        realm.insert(events);

        realm.commitTransaction();
        realm.close();
    }

    public void storeEvents(String n, int d, int i){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Events events = new Events(name, date, img);

        realm.insert(events);

        realm.commitTransaction();
        realm.close();
    }

    public void storeEvents(Events e){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.insert(e);

        realm.commitTransaction();
        realm.close();
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