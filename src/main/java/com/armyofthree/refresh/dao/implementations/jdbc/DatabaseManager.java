package com.armyofthree.refresh.dao.implementations.jdbc;

import com.armyofthree.refresh.dao.DisplacedPersonDao;
import com.armyofthree.refresh.dao.LocationDao;
import com.armyofthree.refresh.dao.VolunteerDao;
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
