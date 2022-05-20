package pgfsd.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/Ecommerce";
    private static String user = "root";
    private static String password = "test1234";

    public static Connection getConnection() {
        if(connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
