package com.example.a4serve;

import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.annotations.PrimaryKey;
import io.realm.RealmObject;

public class Profile extends RealmObject {
    @PrimaryKey
    private String name;
    private String password;

    public Profile() {
        this.name = "someone";
        this.password = "1234";
    }

    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean logInUser(final String enteredName, String enteredPass) {
        Realm realm = Realm.getDefaultInstance();
        Profile person = realm.where(Profile.class).equalTo("name", enteredName).findFirst();

        if(person == null) {
            return false;
        }

        return person.password.equals(enteredPass);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
