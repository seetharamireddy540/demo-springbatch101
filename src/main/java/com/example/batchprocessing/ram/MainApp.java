package com.example.batchprocessing.ram;

import com.example.batchprocessing.ram.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {

        List<Employee> result = new ArrayList<>();

        String SQL_SELECT = "Select * from employee";
        String INSERT_EMPLOYEE = "INSERT INTO employee(name) "
                + "VALUES(?)";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:55000/postgres?currentSchema=ram_store", "postgres", "postgrespw");
             PreparedStatement insert = conn.prepareStatement(INSERT_EMPLOYEE);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            insert.setString(1, "Ram");
            insert.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);

                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

