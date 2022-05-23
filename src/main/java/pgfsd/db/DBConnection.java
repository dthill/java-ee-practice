package pgfsd.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/Ecommerce";
    private static final String user = "root";
    private static final String password = "test1234";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
