package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLDatabaseConnection {
    public static void connectMSSQL() {
        String connectionUrl =
                "jdbc:sqlserver://10.211.55.4.testDatabase.windows.net:1433;"
                        + "database=testDatabase;"
                        + "user=yurez@BB09;"
                        + "password=ifirby;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {

        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
