package HW13;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class);
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema?serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection createConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        LOGGER.info("connection was created");
        return connection;
    }
}
