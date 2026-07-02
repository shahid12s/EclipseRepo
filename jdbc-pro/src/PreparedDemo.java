import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo {

	public static void main(String[] args) {
		// ? is called place-holder, index starts from 1
		String sql = "insert into cust values (?, ?, ?)";
		
		try {
			Connection conn = JdbcFactory.getConnection();
			
			// Creating statement to execute query with params
			PreparedStatement stmt = conn.prepareStatement(sql);
			// Replacing place-holders with command line arg values
			stmt.setInt(1, Integer.parseInt(args[0]));
			stmt.setString(2, args[1]);
			stmt.setString(3, args[2]);
			
			stmt.executeUpdate();
			System.out.println("Record inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
