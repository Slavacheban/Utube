package HW13;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {
    private static Properties properties = new Properties();
    private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class);

    public static Connection createConnection() throws SQLException, IOException{
        properties.load(new FileReader("src/main/java/HW13/connectionData.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USERNAME"), properties.getProperty("PASSWORD"));
        LOGGER.info("connection was created");
        return connection;
    }
}
