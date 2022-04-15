package com.armyofthree.refresh.models.services;

import java.util.List;

public class Location extends Service {
    private int daysAvailable;
    private int daysOccupied;
    private int fullCapacity;
    private int occupiedCapacity;
    private boolean petFriendly;
    private LocationType locationType;

    public Location(String name, String address, String description, List<String> photos, LocationType locationType) {
        super(name, address, ServiceType.LOCATION, description, photos);
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public int getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(int daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public int getDaysOccupied() {
        return daysOccupied;
    }

    public void setDaysOccupied(int daysOccupied) {
        this.daysOccupied = daysOccupied;
    }

    public int getFullCapacity() {
        return fullCapacity;
    }

    public void setFullCapacity(int fullCapacity) {
        this.fullCapacity = fullCapacity;
    }

    public int getOccupiedCapacity() {
        return occupiedCapacity;
    }

    public void setOccupiedCapacity(int occupiedCapacity) {
        this.occupiedCapacity = occupiedCapacity;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }
}
