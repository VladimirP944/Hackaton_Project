package com.armyofthree.refresh.models.users;

import java.util.UUID;

public abstract class User {
    private String name;
    private String email;
    private String phone;
    private UUID id;
    private UserType type;
    private String profilePhoto;
    private String password;

    public User(String name, String email, String phone, UserType type, String profilePhoto, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.profilePhoto = profilePhoto;
        this.id = UUID.randomUUID();
        this.password = password;
    }
}