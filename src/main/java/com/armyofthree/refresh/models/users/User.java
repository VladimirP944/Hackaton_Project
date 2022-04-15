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
}
