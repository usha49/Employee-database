import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String password){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname,user,password);
            if (conn != null){
                System.out.println("Connected to database established.");
            } else{
                System.out.println("Connection to database failed.");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
}
