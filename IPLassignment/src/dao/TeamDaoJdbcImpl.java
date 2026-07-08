package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Team;

public class TeamDaoJdbcImpl implements TeamDao {

    @Override
    public boolean save(Team team) {

        String sql = "insert into Team(team_name) values(?)";

        try {
            Connection conn = JdbcFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, team.getTeamName());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Team find(int teamId) {

        String sql = "select * from Team where team_id=" + teamId;

        try {

            Connection conn = JdbcFactory.getConnection();

            ResultSet rs = conn.createStatement().executeQuery(sql);

            Team team = null;

            if (rs.next()) {
                team = new Team();
                team.setTeamId(rs.getInt(1));
                team.setTeamName(rs.getString(2));
            }

            return team;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Team find(String teamName) {

        String sql = "select * from Team where team_name=?";

        try {

            Connection conn = JdbcFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, teamName);

            ResultSet rs = stmt.executeQuery();

            Team team = null;

            if (rs.next()) {
                team = new Team();
                team.setTeamId(rs.getInt(1));
                team.setTeamName(rs.getString(2));
            }

            return team;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Team> list() {

        String sql = "select * from Team";

        List<Team> teams = new ArrayList<>();

        try {

            Connection conn = JdbcFactory.getConnection();

            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {

                Team team = new Team();

                team.setTeamId(rs.getInt(1));
                team.setTeamName(rs.getString(2));

                teams.add(team);
            }

            return teams;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(int teamId) {

        String sql = "delete from Team where team_id=" + teamId;

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