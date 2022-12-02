package frost.countermobil.Maze.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class ConnectionMySQL {

    private static Connection con;

    public Connection setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql/maze","root","root");
        } catch (SQLException | ClassNotFoundException sqlEx){
            System.err.println(sqlEx);
        }
        return con;
    }
}
