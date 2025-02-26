package dk.easv.transationbacth;

import dk.easv.transationbacth.dao.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @FXML
    protected void onHelloButtonClick() {
        employeeDAO.getAllEmployees().forEach(employee -> {
            System.out.println(employee.getName());
        });
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}