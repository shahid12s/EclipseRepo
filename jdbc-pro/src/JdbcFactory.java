import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public final class JdbcFactory {
	
	private JdbcFactory() {
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mmcoe";
		DriverManager.registerDriver(new Driver());
		Connection conn = DriverManager.getConnection(url, "zubair", "oracle");
		return conn;
	}
}
