package com.armyofthree.refresh.models.users;

public class DisplacedPerson extends User {
    private int numberOfPeople;
    private boolean lookingForJob;
    private boolean lookingForShelter;
    private boolean lookingForBusinessLocation;
    private boolean lookingForFood;
    private boolean lookingForMedicalAssistance;
    private boolean lookingToSellProducts;
    private String documents;
    private boolean pets;

    public DisplacedPerson(String name, String email, String phone, String profilePhoto, int numberOfPeople, String documents, String password) {
        super(name, email, phone, UserType.DISPLACED_PERSON, profilePhoto, password);
        this.numberOfPeople = numberOfPeople;
        this.documents = documents;
    }

    public boolean isLookingForJob() {
        return lookingForJob;
    }

    public void setLookingForJob(boolean lookingForJob) {
        this.lookingForJob = lookingForJob;
    }

    public boolean isLookingForShelter() {
        return lookingForShelter;
    }

    public void setLookingForShelter(boolean lookingForShelter) {
        this.lookingForShelter = lookingForShelter;
    }

    public boolean isLookingForBusinessLocation() {
        return lookingForBusinessLocation;
    }

    public void setLookingForBusinessLocation(boolean lookingForBusinessLocation) {
        this.lookingForBusinessLocation = lookingForBusinessLocation;
    }

    public boolean isLookingForFood() {
        return lookingForFood;
    }

    public void setLookingForFood(boolean lookingForFood) {
        this.lookingForFood = lookingForFood;
    }

    public boolean isLookingForMedicalAssistance() {
        return lookingForMedicalAssistance;
    }

    public void setLookingForMedicalAssistance(boolean lookingForMedicalAssistance) {
        this.lookingForMedicalAssistance = lookingForMedicalAssistance;
    }

    public boolean isLookingToSellProducts() {
        return lookingToSellProducts;
    }

    public void setLookingToSellProducts(boolean lookingToSellProducts) {
        this.lookingToSellProducts = lookingToSellProducts;
    }

    public boolean hasPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }
}
