package pojo;

public class Player {

	private String name, bid;
	private int number;

	public Player(String name, int number, String bid) {
		this.name = name;
		this.number = number;
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", bid=" + bid + ", number=" + number + "]";
	}
}
