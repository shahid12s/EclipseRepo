import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/mmcoe";
		
		try {
//			DriverManager.registerDriver(new Driver());
//			Connection conn = DriverManager.getConnection(url, "zubair", "oracle");
			
			Connection conn = JdbcFactory.getConnection();
			System.out.println("Connection successful");
			
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("DB Name: " + meta.getDatabaseProductName());
			System.out.println("DB Version: " + meta.getDatabaseProductVersion());
			System.out.println("Driver Name: " + meta.getDriverName());
			System.out.println("Driver Version: " + meta.getDriverVersion());
			
		} catch (SQLException e) {
			System.out.println("Connection failed due to...");
			e.printStackTrace();
		}
	}
}
