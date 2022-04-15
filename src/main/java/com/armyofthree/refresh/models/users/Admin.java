package com.armyofthree.refresh.models.users;

public class Admin extends User {
    public Admin(String name, String address, String email, String phone, String profilePhoto, String password) {
        super(name, address, email, phone, UserType.ADMIN, profilePhoto, password);
    }
}
