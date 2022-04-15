package com.armyofthree.refresh.models.services;

import java.util.ArrayList;
import java.util.List;

public class Job extends Service {
    private List<String> educationalRequirements;
    private List<String> languageRequirements;

    public Job(String name, String address, ServiceType type, String description, List<String> photos) {
        super(name, address, type, description, photos);
        this.educationalRequirements = new ArrayList<String>();
        this.languageRequirements = new ArrayList<String>();
    }

    public void addEducationalRequirement(String requirement) {
        educationalRequirements.add(requirement);
    }

    public void addLanguageRequirement(String requirement) {
        languageRequirements.add(requirement);
    }

    public List<String> getEducationalRequirements() {
        return educationalRequirements;
    }

    public List<String> getLanguageRequirements() {
        return languageRequirements;
    }
}
