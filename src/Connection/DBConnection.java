package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String DB_URL ="jdbc:mysql://localhost:3306/foodstoredb";
    private static String userName = "root";
    private static String password="";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,userName,password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
