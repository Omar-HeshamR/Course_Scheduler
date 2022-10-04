/**
 * @author Omar
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection connection;
    private static final String password = "java";
    private static final String username = "java";
    private static final String database = "jdbc:derby://localhost:1527/CourseSchedulerDBOmarRadyohr5003";
    
    public static Connection getConnection(){
        if (connection == null){
           try{
               connection = DriverManager.getConnection(database, username, password);
           }
           catch(SQLException SQLerror){
               SQLerror.printStackTrace();
               System.out.println("Error Occured While Opening Database");
               System.exit(1);
           }
        }
        return connection;
    }
}
