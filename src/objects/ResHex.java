package objects;

import enums.Resource;

/**
 * Provides a Resource Hexagon for Settlers of Catan.  
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 0956
 *
 */
public class ResHex {

	/**
	 * Coordinate of this Resource Hexagon.
	 */
	private final Coord coord;
	
	/**
	 * The resource type of this hexagon.  Must be one of the 5 resource of SOC.
	 */
	private final Resource res;
	
	/**
	 * The dice number corresponding to this hexagon.  Range = [2,6]U[8,12].
	 */
	private final int dice;
	
	/**
	 * Boolean variable.  True if the resource hexagon is blocked.  False otherwise.
	 */
	private boolean isBlocked = false;
	
	/**
	 * Creates a new resource hexagon object.
	 * 
	 * @param c - the coordinate of this hexagon in Coord
	 * @param r - the resource type of this hexagon in Resource
	 * @param dice - the dice number on the hexagon
	 */
	public ResHex(Coord c, Resource r, int dice) {
		this.coord = c;
		this.res = r;
		this.dice = dice;
	}
	
	/**
	 * TO BE USED BY INTERNAL FUNCTIONS ONLY
	 * 
	 * Creates a new resource hexagon object with blocked specification.
	 * 
	 * @param c - the coordinate of this hexagon in Coord
	 * @param r - the resource type of this hexagon in Resource
	 * @param dice - the dice number on the hexagon
	 * @param b - true if the hexagon is blocked by the robber,
	 * 				false otherwise.
	 */
	private ResHex(Coord c, Resource r, int dice, boolean b) {
		this.coord = c;
		this.res = r;
		this.dice = dice;
		this.isBlocked = b;
	}
	
	/**
	 * Returns if this resource hexagon is blocked or not.
	 * 
	 * @return boolean - true if this resource hexagon is blocked,
	 * 						false otherwise
	 */
	public boolean isBlocked() { return this.isBlocked; }
	
	/**
	 * Returns the dice number on this resource hexagon.
	 * 
	 * @return int - the dice number of this hexagon
	 */
	public int diceNumber() { return this.dice; }
	
	/**
	 * Returns the resource type of this hexagon.
	 * 
	 * @return Resource - the type of Resource this hexagon is
	 */
	public Resource getResource() { return this.res; }
	
	/**
	 * Returns the coordinate of this resource hexagon.
	 * 
	 * @return Coord - the coordinate of this resource hexagon
	 */
	public Coord getCoordinate() { return this.coord; }
	
	/**
	 * Blocks this hexagon.
	 */
	public void block() { this.isBlocked = true; }
	
	/**
	 * Unblocks his hexagon.
	 */
	public void unblock() { this.isBlocked = false; }
	
	/**
	 * Generates a hashcode based on the coordinate of the coordinate and resource type.
	 */
	public int hashCode() { return this.coord.hashCode() + this.res.ordinal(); }
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * Some other object is "equal to" this one iff:
	 * The coordinates, resource type and dice number are equal.
	 */
	public boolean equals(Object o) {
		if ( !(o instanceof ResHex) ) return false;
		ResHex rh = (ResHex) o;
		if ( this.hashCode() != rh.hashCode() ) return false;
		return this.coord.equals(rh.coord) && 
				this.res.equals(rh.res) && 
				(this.dice == rh.dice);
	}
	
	/**
	 * Returns a String representation of this object as: 
	 * 	HEXAGON (x,y) [dice number] [BLOCKED/UNBLOCKED]
	 */
	public String toString() { 
		return "HEXAGON " 
				+ this.coord.toString() 
				+ " " + this.res.toString() 
				+ " " + this.dice + " " 
				+ (isBlocked ? "BLOCKED" : "UNBLOCKED"); 
	}
	
	/**
	 * DOES NOT RETURN A NEW COPY OF THIS OBJECT.
	 * Use makeDeepCopy() for a new instance of this object.
	 * 
	 * Returns a shallow copy.
	 */
	public ResHex clone() { return this; }
	
	/**
	 * Return a new instance of this object such that 
	 * 	x.makeDeepCopy != x but x.makeDeepCopy.equals(x) is true.
	 * 
	 * @return ResHex - a copy of this object.
	 */
	public ResHex makeDeepCopy() { return new ResHex(this.coord.makeDeepCopy(), this.res, this.dice, this.isBlocked); }
	
}
