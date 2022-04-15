package com.armyofthree.refresh.models.services;

import java.util.List;
import java.util.UUID;

public abstract class Service {
    private String name;
    private String address;
    private ServiceType type;
    private UUID id;
    private String description;
    private List<String> photos;

    public Service(String name, String address, ServiceType type, String description, List<String> photos) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.description = description;
        this.photos = photos;
        this.id = UUID.randomUUID();
    }
}
