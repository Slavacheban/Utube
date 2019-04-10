package HW13;


import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLApplication {
    private static final Logger LOGGER = Logger.getLogger(SQLApplication.class);
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema?serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        connection.close();
    }
}
