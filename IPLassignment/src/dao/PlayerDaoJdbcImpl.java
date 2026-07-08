package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Player;

public class PlayerDaoJdbcImpl implements PlayerDao {

	@Override
	public boolean save(Player player, int teamId) {

		String sql = "insert into Player values(?,?,?,?)";

		try {
			Connection conn = JdbcFactory.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, player.getNumber());
			stmt.setString(2, player.getName());
			stmt.setString(3, player.getBid());
			stmt.setInt(4, teamId);

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Player find(int number) {

		String sql = "select * from Player where jersey_no=" + number;

		try {
			Connection conn = JdbcFactory.getConnection();

			ResultSet rs = conn.createStatement().executeQuery(sql);

			Player player = null;

			if (rs.next()) {
				player = new Player(
						rs.getString(2),
						rs.getInt(1),
						rs.getString(3));
			}

			return player;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Player> list() {

		String sql = "select * from Player";

		List<Player> players = new ArrayList<>();

		try {
			Connection conn = JdbcFactory.getConnection();

			ResultSet rs = conn.createStatement().executeQuery(sql);

			while (rs.next()) {

				Player player = new Player(
						rs.getString(2),
						rs.getInt(1),
						rs.getString(3));

				players.add(player);
			}

			return players;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Player> findByTeam(int teamId) {

		String sql = "select * from Player where team_id=?";

		List<Player> players = new ArrayList<>();

		try {
			Connection conn = JdbcFactory.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, teamId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Player player = new Player(
						rs.getString(2),
						rs.getInt(1),
						rs.getString(3));

				players.add(player);
			}

			return players;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(int number) {

		String sql = "delete from Player where jersey_no=" + number;

		try {
			Connection conn = JdbcFactory.getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate(sql);

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}