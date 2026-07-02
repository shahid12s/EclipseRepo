import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

	public static void main(String[] args) {
		
		String sql = "insert into cust values (12, 'Polo', 'Pune')";
		
		try {
			Connection conn = JdbcFactory.getConnection();
			// Creating statement to execute hard-coded query
			Statement stmt = conn.createStatement();
			// Performing DML operation
			stmt.executeUpdate(sql);
			System.out.println("Record inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
