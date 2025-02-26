package dk.easv.transationbacth.dao;

import dk.easv.transationbacth.DBManager;
import dk.easv.transationbacth.be.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private DBManager dbManager = new DBManager();
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        // SQL query to retrieve data
        String query = "SELECT * FROM employee"; // Replace with your table name

        // Connection and statement objects
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish connection
            conn = dbManager.getConnection();

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute the query
            rs = stmt.executeQuery(query);

            // 4. Process the result
            while (rs.next()) {
                int id = rs.getInt("id"); // Adjust column name (id) based on your table
                String name = rs.getString("Name"); // Adjust column name (name) based on your table
                int salary = rs.getInt("Salary");
                employees.add(new Employee(name, salary));
                // Print the result or process it further
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } finally {
            // 5. Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

}
