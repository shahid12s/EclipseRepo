package service;

import java.util.List;

import pojo.Player;
import pojo.Team;

public interface IPLService {

	boolean addTeam(Team team);

	boolean addPlayer(Player player, int teamId);

	Team searchTeam(int teamId);

	Team searchTeam(String teamName);

	List<Player> displayPlayers();

	List<Player> displayPlayersByTeam(int teamId);

	boolean removeTeam(int teamId);

	boolean removePlayer(int number);

}