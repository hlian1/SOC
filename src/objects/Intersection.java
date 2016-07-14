package objects;

import enums.BuildingType;

public class Intersection {
	
	private final Coord c;
	private boolean canHaveBuilding = true;
	private Building b = null;
	private boolean isPort = false;
	private Port p = null;
	
	public Intersection(Coord c) {
		this.c = c;
	}
	
	public Coord getCoordinates() { return this.c; }
	public boolean buildingAllowed() { return this.canHaveBuilding; }
	public Building getBuilding() { return this.b; }
	public Port getPort() { return this.p; }
	public boolean isPort() { return this.isPort; }
	
	public void buildBuilding(BuildingType t, Player p) { this.b = new Building(this.c, t, p); }
	public void makePort(Port p) { this.p = p; }
	
	/*
	public void destroyBuilding() { this.b = null; }
	public void destroyPort() { this.p = null; }
	*/
}
