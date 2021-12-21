package connection;

import java.sql.*;

public class MySQLcon {
    
    private static String DRIVER = "com.mysql.cj.jdbc.Driver" ;
    private static String URL = "jdbc:mysql://localhost:3306/escola";
    private static String USER = "admin";
    private static String PASS = "Kaio2004";

    public static Connection iniciarconexao() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException | SQLException e ) {

            throw new RuntimeException("ERROR" + e);

        }

    }

    public static void encerrarcon( Connection connection) {

        if (connection != null) {
            
            try {
            connection.close();
            }

            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void encerrarcon(Connection connection, PreparedStatement stmt) {
        encerrarcon(connection);

        if (connection != null) {
            try {
                stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void encerrarcon(Connection connection, PreparedStatement stmt, ResultSet rst) {
        encerrarcon(connection,stmt);

        if (connection != null) {
            try {
                rst.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
