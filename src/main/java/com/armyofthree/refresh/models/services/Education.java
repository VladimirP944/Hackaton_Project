package com.armyofthree.refresh.models.services;

import java.util.List;

public class Education extends Service {
    private boolean hasKindergarten;
    private boolean hasPrimary;
    private boolean hasSecondary;
    private boolean hasHighSchool;
    private boolean hasCollege;
    private boolean hasTradeSchool;

    public Education(String name, String address, ServiceType type, String description, List<String> photos) {
        super(name, address, type, description, photos);
        this.hasCollege = false;
        this.hasHighSchool = false;
        this.hasKindergarten = false;
        this.hasPrimary = false;
        this.hasSecondary = false;
        this.hasTradeSchool = false;
    }

    public boolean isHasTradeSchool() {
        return hasTradeSchool;
    }

    public void setHasTradeSchool(boolean hasTradeSchool) {
        this.hasTradeSchool = hasTradeSchool;
    }

    public boolean hasKindergarten() {
        return hasKindergarten;
    }

    public void setHasKindergarten(boolean hasKindergarten) {
        this.hasKindergarten = hasKindergarten;
    }

    public boolean hasPrimary() {
        return hasPrimary;
    }

    public void setHasPrimary(boolean hasPrimary) {
        this.hasPrimary = hasPrimary;
    }

    public boolean hasSecondary() {
        return hasSecondary;
    }

    public void setHasSecondary(boolean hasSecondary) {
        this.hasSecondary = hasSecondary;
    }

    public boolean hasHighSchool() {
        return hasHighSchool;
    }

    public void setHasHighSchool(boolean hasHighSchool) {
        this.hasHighSchool = hasHighSchool;
    }

    public boolean isHasCollege() {
        return hasCollege;
    }

    public void setHasCollege(boolean hasCollege) {
        this.hasCollege = hasCollege;
    }
}
