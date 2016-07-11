package server;

import java.io.PrintWriter;

public class SClient {

	private final String USERNAME;
	
	private PrintWriter out;
	
	private final long PLAYER_ID;
	
	private final long BOARD_ID;
	
	public SClient(String user, long pid, long bid) {
		this.USERNAME = user;
		this.PLAYER_ID = pid;
		this.BOARD_ID = bid;
	}
	
	public String getUsername() { return this.USERNAME; }
	public long getPlayerID() { return this.PLAYER_ID; }
	public long getBoardID() { return this.BOARD_ID; }
	
	public PrintWriter getPrintWriter() { return this.out; }
	
	public boolean equals(Object o) {
		if ( ! (o instanceof SClient) ) return false;
		SClient s = (SClient) o;
		return this.PLAYER_ID == s.getPlayerID() && this.BOARD_ID == s.getBoardID();
	}
	
}
