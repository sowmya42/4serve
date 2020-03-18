package com.example.a4serve;

public class Events {
    private static String  name;
    private static int date;
    private static int img;
    public Events(String n, int d, int p){
        name = n;
        date = d;
        img = p;
    }

    public static int getImg(){
        return img;
    }
    public static int getDate(){
        return date;
    }
    public static String name(){
        return name;
    }
}
