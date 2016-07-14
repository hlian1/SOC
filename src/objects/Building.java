package objects;

import enums.BuildingType;

public class Building {

	private final Coord c;
	private BuildingType t;
	private Player owner;
	
	public Building(Coord c, BuildingType t, Player p) {
		this.c = c;
		this.c.makeImmutable();
		this.t= t;
		this.owner = p;
	}
	
	public Coord getCoord() { return this.c; }
	public BuildingType getType() { return this.t; }
	public Player getOwner() { return this.owner; }
	
	public void changeOwner(Player p) { this.owner = p; }
	public void upgradeToCity() { this.t = BuildingType.CITY; }
	public void downgradeToSettlement() { this.t = BuildingType.SETTLEMENT; }
	
	public boolean equals(Object o) {
		if ( !(o instanceof Building) ) return false;
		try {
			Building b = (Building) o;
			return this.t == b.getType() 
					&& this.c.equals(b.getCoord()) 
					&& this.owner.equals(b.getOwner());
		} catch ( Exception e ) {
			return false;
		}
	}
	
	public Building clone() { return this; }
	
	public Building makeDeepCopy() { return new Building(this.c, this.t, this.owner); }
	
	public String toString() { return "building " + this.t + "@" + this.c + " " + this.owner.getID();}
}
