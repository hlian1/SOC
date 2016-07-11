package objects;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import enums.BuildingMaterial;
import enums.DevType;
import enums.Resource;
import sm.SM;

/**
 * Provides a Player for Settlers of Catan
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 1150
 *
 */
public class Player {

	private Socket socket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private boolean socketBroken = true;
	
	private final String NAME;
	private final long ID;
	private int vp;
	private int longestRoad;
	
	private Vector<ResCard> res = new Vector<ResCard>();
	private Vector<DevCard> dev = new Vector<DevCard>();
	private Vector<BuildingMaterial> material = new Vector<BuildingMaterial>();
	private Vector<Road> roads = new Vector<Road>();
	
	public Player(String name, int id) {
		this.NAME = name;
		this.ID = id;
	}
	
	public void addVP(int vp) { this.vp += vp; }
	public void subtractVP(int vp) { addVP(-vp); }
	public void addResource(Resource r) { this.res.add(new ResCard(r)); }
	public void useResource(Resource r) { this.res.remove(new ResCard(r)); }
	public void addDevCard(DevType t) { this.dev.add(new DevCard(t)); }
	public void useDevCard(DevType t) { this.dev.get(this.dev.indexOf(new DevCard(t))).use(); }
	public void addMaterials(BuildingMaterial b) { this.material.add(b); }
	public void setLongestRoad(int length) { this.longestRoad = length; }
	public void buildRoad(Road r) { this.roads.add(r); }
	
	public int getVP() { return this.vp; }
	public int getRoadLength() { return this.longestRoad; }
	public long getID() { return this.ID; }
	public String getName() { return this.NAME; }
	public Vector<Road> getRoads() { return this.roads; }
	
	public int getNumResCard() { return this.res.size(); }
	public int getNumDevCard() { return this.dev.size(); }
	public int getNumUsedDevCards() { return SM.getUsedDevCards(this.dev); }
	public int getNumUnusedDevCards() { return this.getNumDevCard() - this.getNumUsedDevCards(); }

	public int getNumDevCard(DevType t) { return SM.getNumDevCard(this.dev, t); }
	public int getNumUsedDevCards(DevType t) { return SM.getUsedDevCards(this.dev, t); } 
}
