package id.putraprima.mvvmlogin.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Account {
    public String username = "altalarik@mail.com";
    public String password = "polinema";

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected Account(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
