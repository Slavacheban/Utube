package HW13;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLDevelopers {
    private static final Logger LOGGER = Logger.getLogger(SQLDevelopers.class);
    private static final String SELECT_ID = "SELECT * FROM developers WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM developers";
    private static final String INSERT = "INSERT INTO developers(name, city, age, salary) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE developers SET name = ?, city = ?, age = ?, salary = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM developers WHERE id = ?";

    public Developer selectId(int id) throws SQLException, IOException {
        ResultSet resultSet = null;
        Developer developer = new Developer();
        try (Connection connection = MySQLConnection.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            developer.setId(resultSet.getInt(1)).setName(resultSet.getString(2))
                    .setCity(resultSet.getString(3))
                    .setAge(resultSet.getInt(4))
                    .setSalary(resultSet.getInt(5));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            resultSet.close();
        }
        return developer;
    }

    public List<Developer> selectAll() throws SQLException, IOException {
        ResultSet resultSet = null;
        List<Developer> list = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                list.add(new Developer().setName(resultSet.getString(2))
                        .setCity(resultSet.getString(3))
                        .setAge(resultSet.getInt(4))
                        .setSalary(resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            resultSet.close();
        }
        return list;
    }

    public void deleteById(int id) throws SQLException, IOException {
        PreparedStatement preparedStatement = null;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            preparedStatement.close();
        }
    }

    public void insert(Developer developer) throws SQLException, IOException {
        PreparedStatement preparedStatement = null;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(2, developer.getName());
            preparedStatement.setString(3, developer.getCity());
            preparedStatement.setInt(4, developer.getAge());
            preparedStatement.setInt(5, developer.getSalary());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            preparedStatement.close();
        }
    }

    public void update(Developer developer) throws SQLException, IOException {
        PreparedStatement preparedStatement = null;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, developer.getId());
            preparedStatement.setString(2, developer.getName());
            preparedStatement.setString(3, developer.getCity());
            preparedStatement.setInt(4, developer.getAge());
            preparedStatement.setInt(5, developer.getSalary());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            preparedStatement.close();
        }
    }
}
