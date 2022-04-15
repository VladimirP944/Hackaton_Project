package com.armyofthree.refresh.models.users;

import com.armyofthree.refresh.models.services.Location;
import com.armyofthree.refresh.models.services.MedicalAssistance;

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
}
