package com.armyofthree.refresh.models.dao.implementations.jdbc;

import com.armyofthree.refresh.models.dao.DisplacedPersonDao;
import com.armyofthree.refresh.models.dao.VolunteerDao;
import com.armyofthree.refresh.models.dao.LocationDao;
import com.armyofthree.refresh.models.services.Location;
import com.armyofthree.refresh.models.users.DisplacedPerson;
import com.armyofthree.refresh.models.users.Volunteer;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {

    private DisplacedPersonDao displacedPersonDao;
    private VolunteerDao volunteerDao;
    private LocationDao locationDao;


    public void setup() throws SQLException {
        DataSource dataSource = connect();
        displacedPersonDao = new DisplacedPersonDaoJdbc();
        volunteerDao = new VolunteerDaoJdbc();
        locationDao = new LocationDaoJdbc();
    }

//    DisplacedPerson --------------------

    public void saveDisplacedPerson(DisplacedPerson displacedPerson) {
        displacedPersonDao.add(displacedPerson);
    }

    public DisplacedPerson loadDisplacedPerson(String username) {
        return displacedPersonDao.getDisplacedPerson(username);
    }

    public void updateDisplacedPerson(DisplacedPerson displacedPerson) {
        displacedPersonDao.update(displacedPerson);
    }

    public void deleteDisplacedPerson(int id) {
        displacedPersonDao.delete(id);
    }

//    Volunteer ---------------------------

    public void saveVolunteer(Volunteer volunteer) {
        volunteerDao.add(volunteer);
    }

    public Volunteer loadVolunteer(String username) {
        return volunteerDao.getVolunteer(username);
    }

    public void updateVolunteer(Volunteer volunteer) {
        volunteerDao.update(volunteer);
    }

    public void deleteVolunteer(int id) {
        volunteerDao.delete(id);
    }

    //    Location ---------------------------

    public void saveLocation(Location location) {
        locationDao.add(location);
    }

    public <T> Location loadLocation(T criteria) {
        return locationDao.getLocation(criteria);
    }

    public void updateLocation(Location location) {
        locationDao.update(location);
    }

    public void deleteLocation(int id) {
        locationDao.delete(id);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        ApplicationProperties properties = new ApplicationProperties();
        String dbName = properties.readProperty("database");
        String user = properties.readProperty("user");
        String password = properties.readProperty("password");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }
}
