package com.armyofthree.refresh.dao.implementations.jdbc;

import com.armyofthree.refresh.dao.VolunteerDao;
import com.armyofthree.refresh.models.users.DisplacedPerson;
import com.armyofthree.refresh.models.users.Volunteer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VolunteerDaoJdbc implements VolunteerDao {

    private DataSource dataSource;

    public VolunteerDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Volunteer> getAll() {
        return null;
    }

    @Override
    public Volunteer getVolunteer(String username) {
        return null;
    }

    @Override
    public void add(Volunteer homeOwner) {

    }

    @Override
    public void update(Volunteer homeOwner) {

    }

    @Override
    public void delete(int id) {

    }
}
