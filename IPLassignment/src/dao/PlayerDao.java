package dao;

import java.util.List;
import pojo.Player;

public interface PlayerDao {

    boolean save(Player player, int teamId);

    Player find(int jerseyNo);

    List<Player> list();

    List<Player> findByTeam(int teamId);

    boolean delete(int jerseyNo);
}