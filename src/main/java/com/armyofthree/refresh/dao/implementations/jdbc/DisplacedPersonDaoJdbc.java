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
        try(Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO applicants (username, password, photo_id, name, extra_persons, phone_number, documents, type, applied_for_home) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, displacedPerson.getUsername());
            st.setString(2, displacedPerson.getPassword());
            st.setString(3, displacedPerson.getPhoto());
            st.setString(4, displacedPerson.getName());
            st.setBoolean(5, displacedPerson.getExtraPersons());
            st.setString(6, displacedPerson.getPhoneNumber());
            st.setString(7, displacedPerson.getDocuments());
            st.setString(8, displacedPerson.getType());
            st.setBoolean(9, displacedPerson.getAppliedForHome());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(DisplacedPerson displacedPerson) {

    }

    @Override
    public void delete(int id) {

    }
}