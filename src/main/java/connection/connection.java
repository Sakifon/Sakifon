package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    /*private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/exam";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "yous1/2*3-LOLIl";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Database is established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
*/
	private static Connection connection;
	static {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection= DriverManager.getConnection
	("jdbc:mysql://localhost:3306/exam","root","");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public static Connection getConnection() {
	return connection;
	}
}