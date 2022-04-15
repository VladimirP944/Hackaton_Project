package com.armyofthree.refresh.models.services;

import java.util.List;

public class MedicalAssistance extends Service {
    private AssistanceType assistanceType;

    public MedicalAssistance(String name, String address, ServiceType type, String description, List<String> photos, AssistanceType assistanceType) {
        super(name, address, type, description, photos);
        this.assistanceType = assistanceType;
    }
}
