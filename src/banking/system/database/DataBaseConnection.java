package banking.system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {
    private Connection conn = null;
    private Logger logger = Logger.getLogger(DataBaseConnection.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "test123";

    public DataBaseConnection() {
        try {
            // create a connection to the database Connection conn = connection.getConnection();ase
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(SQLException e) {
            logger.log(Level.SEVERE,e.getMessage());
            closeConnection(conn);
        }
    }

    public Connection getConection() {
        return this.conn;
    }

    public void closeConnection(Connection conn) {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE,e.getMessage());
            }
    }
}
