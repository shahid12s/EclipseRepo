package service;

import java.util.List;

import dao.PlayerDao;
import dao.PlayerDaoJdbcImpl;
import dao.TeamDao;
import dao.TeamDaoJdbcImpl;
import pojo.Player;
import pojo.Team;

public class IPLServiceImpl implements IPLService {

	private TeamDao teamDao;
	private PlayerDao playerDao;

	public IPLServiceImpl() {
		teamDao = new TeamDaoJdbcImpl();
		playerDao = new PlayerDaoJdbcImpl();
	}

	@Override
	public boolean addTeam(Team team) {
		return teamDao.save(team);
	}

	@Override
	public boolean addPlayer(Player player, int teamId) {
		return playerDao.save(player, teamId);
	}

	@Override
	public Team searchTeam(int teamId) {
		return teamDao.find(teamId);
	}

	@Override
	public Team searchTeam(String teamName) {
		return teamDao.find(teamName);
	}

	@Override
	public List<Player> displayPlayers() {
		return playerDao.list();
	}

	@Override
	public List<Player> displayPlayersByTeam(int teamId) {
		return playerDao.findByTeam(teamId);
	}

	@Override
	public boolean removeTeam(int teamId) {
		return teamDao.delete(teamId);
	}

	@Override
	public boolean removePlayer(int number) {
		return playerDao.delete(number);
	}

}