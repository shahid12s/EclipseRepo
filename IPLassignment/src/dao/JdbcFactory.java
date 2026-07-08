package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcFactory {

    private JdbcFactory() {
    }

    public static Connection getConnection() throws SQLException {

        Properties prop = new Properties();

        try {

            prop.load(new FileReader("src/iplsql.info"));

            Class.forName(prop.getProperty("driver"));

            Connection con = DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("pass"));

            return con;

        } catch (ClassNotFoundException | IOException e) {
            throw new SQLException(e.getMessage());
        }
    }
}