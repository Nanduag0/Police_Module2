package com.example.policemodule.police;

public class User {

    public String name;
    public String phoneno;
    public String email;

    public String getEmail() {
        return email;
    }

    public User(String name, String phoneno, String email) {
        this.name = name;
        this.phoneno = phoneno;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
