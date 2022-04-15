package com.armyofthree.refresh.models.users;

import java.util.UUID;

public abstract class User {
    private String name;
    private String address;
    private String email;
    private String phone;
    private UUID id;
    private UserType type;
    private String profilePhoto;
    private String password;

    public User(String name, String address, String email, String phone, UserType type, String profilePhoto, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.profilePhoto = profilePhoto;
        this.id = UUID.randomUUID();
        this.password = password;
    }
}