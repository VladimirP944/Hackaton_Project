package com.armyofthree.refresh.models.dao;

import com.armyofthree.refresh.models.services.Location;

import java.util.ArrayList;

public interface LocationDao {
    <T> ArrayList<Location> getAll(T criteria);
    <T> Location getLocation(T criteria);
    void add(Location location);
    void update(Location location);
    void delete(int id);
}
