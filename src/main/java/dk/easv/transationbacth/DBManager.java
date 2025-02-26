package dk.easv.transationbacth;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DBManager {
    private final SQLServerDataSource dataSource;

    public DBManager() {
        dataSource = new SQLServerDataSource();
        dataSource.setDatabaseName("erimar01JDBCTest");
        dataSource.setUser("CSe2024b_e_7"); // Better to use env variables
        dataSource.setPassword("CSe2024bE7!24"); // Better to use env variables
        dataSource.setServerName("EASV-DB4");
        dataSource.setPortNumber(1433);
        dataSource.setTrustServerCertificate(true);
    }

    public DBManager(SQLServerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLServerException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null; // Consider throwing a custom exception instead
        }
    }
}
