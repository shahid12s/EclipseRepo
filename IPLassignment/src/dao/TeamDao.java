package dao;

import java.util.List;
import pojo.Team;

public interface TeamDao {

    boolean save(Team team);

    Team find(int teamId);

    Team find(String teamName);

    List<Team> list();

    boolean delete(int teamId);
}