package com.armyofthree.refresh.models.users;

import com.armyofthree.refresh.models.services.*;

import java.util.ArrayList;
import java.util.List;

public class Volunteer extends User{
    private List<Location> homes;
    private List<Location> businessSpaces;
    private List<Job> jobs;
    private List<Food> foodServices;
    private List<Education> schools;
    private List<MedicalAssistance> medicalAssistanceServices;
    private String record;
    private String identityCard;


    public Volunteer(String name, String email, String phone, UserType type, String profilePhoto, String record, String identityCard, String password) {
        super(name, email, phone, UserType.VOLUNTEER, profilePhoto, password);
        this.record = record;
        this.identityCard = identityCard;
        this.homes = new ArrayList<Location>();
        this.businessSpaces = new ArrayList<Location>();
    }

    public void addHome(Location location) {
        homes.add(location);
    }

    public void addBusinessSpace(Location location) {
        businessSpaces.add(location);
    }

    public List<Location> getHomes() {
        return homes;
    }

    public List<Location> getBusinessSpaces() {
        return businessSpaces;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Food> getFoodServices() {
        return foodServices;
    }

    public List<Education> getSchools() {
        return schools;
    }

    public List<MedicalAssistance> getMedicalAssistanceServices() {
        return medicalAssistanceServices;
    }

    public String getRecord() {
        return record;
    }

    public String getIdentityCard() {
        return identityCard;
    }
}
