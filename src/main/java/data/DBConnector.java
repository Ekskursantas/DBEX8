package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private Connection connection = null;

    //Constants
    private static final String URL	     = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Parkuras1996";

    public DBConnector() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = null;
        connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);

    }

    public Connection getConnection() {
        return this.connection;
}

}
