package com.armyofthree.refresh.models.dao;

import com.armyofthree.refresh.models.users.DisplacedPerson;

import java.util.ArrayList;

public interface DisplacedPersonDao {
    ArrayList<DisplacedPerson> getAll();
    DisplacedPerson getDisplacedPerson(String username);
    void add(DisplacedPerson displacedPerson);
    void update(DisplacedPerson displacedPerson);
    void delete(int id);
}
