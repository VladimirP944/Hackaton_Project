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
        try(Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM home_owners";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            ArrayList<Volunteer> allVolunteers = new ArrayList<>();

            while (rs.next()) {

                String name = rs.getString(1);
                String email = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String type = rs.getString(4);
                String profilePhoto = rs.getString(5);
                String password =rs.getString(6);
                String criminalRecord = rs.getString(7);
                String identity_card = rs.getString(8);

                Volunteer volunteer = new Volunteer(name,
                                                            email,
                                                            phoneNumber,
                                                            type,
                                                            profilePhoto,
                                                            criminalRecord,
                                                            password,
                                                            identity_card);

                allVolunteers.add(volunteer);
            }
            return allVolunteers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
