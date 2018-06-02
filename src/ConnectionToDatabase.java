import java.sql.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class ConnectionToDatabase {
    static Connection connection;

    public void openConnection() throws SQLException {
        String URL  ="jdbc:mysql://localhost:3306/Lab10";
        String USERNAME = "root";
        String PASSWORD = "Admin1";
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
    }

    public  String getInfo(String name,String password) throws SQLException {
        ConnectionToDatabase connection = new ConnectionToDatabase();
        connection.openConnection();
        PreparedStatement statement =  ConnectionToDatabase.connection.prepareStatement("Select * from authentication");
        ResultSet rs = statement.executeQuery("Select * from authentication");
        while(rs.next()){
            if(rs.getString("name").equals(name) && rs.getString("password").equals(password)){
                return rs.getString("role");
            }
        }
        return "";
    }
}

