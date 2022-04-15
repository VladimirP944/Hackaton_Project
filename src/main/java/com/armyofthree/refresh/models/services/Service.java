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
}
