package objects;

import java.util.HashMap;
import java.util.Vector;

import enums.DevType;
import enums.Resource;
import sm.SM;

/**
 * Provides a Settlers of Catan Board object.
 * 
 * @author Hau Lian
 * @version Tuesday, July 5th, 2016 2123
 *
 */
public class Board {
	
	private final int SIZE;
	private final long ID;
	
	private int numPlayers;

	private int turn;
	private Player currentPlayer;
	
	private Vector<Player> players = new Vector<Player>();
	private Vector<ResHex> hexagons = new Vector<ResHex>();
	
	private Vector<DevCard> devCards = new Vector<DevCard>();
	private HashMap<Coord, Boolean> ports = new HashMap<Coord, Boolean>();
	
	private Coord robber;
	
	public Board(int size, long ID) {
		this.SIZE = size;
		this.ID = ID;
		this.hexagons = SM.generateHexagons(this.SIZE);
		this.devCards = SM.generateDevCards(this.SIZE);
	}
	
	public long getID() { return this.ID; }
	
	public void addPlayer(Player p) { this.players.add(p); this.numPlayers++; }
	public void removePlayer(Player p) { this.players.remove(p); this.numPlayers--; }
	
	public void givePlayerResource(Player p, Resource r) { 
		this.players.get(this.players.indexOf(p)).addResource(r);
	}
	
	public void takePlayerResource(Player p, Resource r) {
		this.players.get(this.players.indexOf(p)).useResource(r);
	}
	
	public void useDevCard(Player p, DevType t) {
		this.players.get(this.players.indexOf(p)).useDevCard(t);
	}
	
	public void startGame() {
		this.turn = 0;
		this.currentPlayer = this.players.get(this.turn);
		this.numPlayers = this.players.size();
	}
	
	public void nextTurn() {
		this.turn = (this.turn + 1) % this.numPlayers;
		this.currentPlayer = this.players.get(this.turn);
	}

}
