import java.sql.Connection;
import java.sql.DriverManager; //manages JDBC driver
import java.io.InputStream; //for reading config-file
import java.util.Properties; // stores key-value pair

public class DbFunctions {
    public static Connection connect_to_db(){
        Properties props = new Properties();

        //loading config.properties as a resource
        try (InputStream input = DbFunctions.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties.");
            }
            props.load(input);
            String url = "jdbc:postgresql://localhost:5432/";
            String dbname = props.getProperty("db.name");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            Connection conn = DriverManager.getConnection(url + dbname, user, password);
            System.out.println("Connection to database established.");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("Connection to database failed.", e);
        }
    }
}
