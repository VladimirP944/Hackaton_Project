package com.armyofthree.refresh.dao.implementations.jdbc;

import com.armyofthree.refresh.dao.DisplacedPersonDao;
import com.armyofthree.refresh.models.users.DisplacedPerson;
import com.armyofthree.refresh.models.users.UserType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplacedPersonDaoJdbc implements DisplacedPersonDao {
    private DataSource dataSource;

    public DisplacedPersonDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<DisplacedPerson> getAll() {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM applicants";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            ArrayList<DisplacedPerson> allDisplacedPersons = new ArrayList<>();

            while (rs.next()) {

                String email = rs.getString(1);
                String password =rs.getString(2);
                String profilePhoto = rs.getString(3);
                String name = rs.getString(4);
                int numberOfPeople = rs.getInt(5);
                String phone = rs.getString(6);
                String documents = rs.getString(7);
                Boolean appliedForHome = rs.getBoolean(8);

                DisplacedPerson person = new DisplacedPerson(name,
                                                            email,
                                                            phone,
                                                            profilePhoto,
                                                            numberOfPeople,
                                                            documents,
                                                            password);

                person.setAppliedForHome(appliedForHome);
                allDisplacedPersons.add(person);
            }

            return allDisplacedPersons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DisplacedPerson getDisplacedPerson(String username) {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM applicants WHERE username = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String email = rs.getString(1);
            String password =rs.getString(2);
            String profilePhoto = rs.getString(3);
            String name = rs.getString(4);
            int numberOfPeople = rs.getInt(5);
            String phone = rs.getString(6);
            String documents = rs.getString(7);
            Boolean appliedForHome = rs.getBoolean(8);

            DisplacedPerson person = new DisplacedPerson(name,
                    email,
                    phone,
                    profilePhoto,
                    numberOfPeople,
                    documents,
                    password);

            person.setAppliedForHome(appliedForHome);
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(DisplacedPerson displacedPerson) {

    }

    @Override
    public void update(DisplacedPerson displacedPerson) {

    }

    @Override
    public void delete(int id) {

    }
}
