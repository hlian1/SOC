package objects;

import java.util.Vector;

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
	
	private Vector<Player> players = new Vector<Player>();
	private Vector<ResHex> hexagons = new Vector<ResHex>();
	
	private Vector<DevCard> devCards = new Vector<DevCard>();
	private Vector<Coord> ports = new Vector<Coord>();
	
	private Coord robber;
	
	public Board(int size, long ID) {
		this.SIZE = size;
		this.ID = ID;
		this.hexagons = SM.generateHexagons(this.SIZE);
		this.devCards = SM.generateDevCards(this.SIZE);
		
	}

}
