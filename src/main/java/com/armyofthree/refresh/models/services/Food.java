package com.armyofthree.refresh.models.services;

import java.util.ArrayList;
import java.util.List;

public class Food extends Service {
    private List<String> menu;
    private boolean isVegan;
    private boolean isVegetarian;
    private boolean isHalal;
    private boolean isKosher;

    public Food(String name, String address, ServiceType type, String description, List<String> photos) {
        super(name, address, type, description, photos);
        this.menu = new ArrayList<String>();
    }

    public void addFoodToMenu(String food) {
        menu.add(food);
    }

    public List<String> getMenu() {
        return menu;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isHalal() {
        return isHalal;
    }

    public void setHalal(boolean halal) {
        isHalal = halal;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }
}
