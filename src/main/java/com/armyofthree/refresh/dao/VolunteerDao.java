package com.armyofthree.refresh.dao;

import com.armyofthree.refresh.models.users.Volunteer;

import java.util.ArrayList;

public interface VolunteerDao {
    ArrayList<Volunteer> getAll();
    Volunteer getVolunteer(String username);
    void add(Volunteer volunteer);
    void update(Volunteer volunteer);
    void delete(int id);
}
