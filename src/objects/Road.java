package objects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides a Road for Settlers of Catan
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 1220
 */
public class Road {
	
	/**
	 * First end-point of the road
	 */
	private final Coord C1;
	
	/**
	 * Second end-point of the road
	 */
	private final Coord C2;
	
	/**
	 * Creates a new Road object at specified end-points.
	 * 
	 * @param c1 - first end-point
	 * @param c2 - second end-point
	 */
	public Road(Coord c1, Coord c2) {
		this.C1 = c1;
		this.C2 = c2;
	}
	
	/**
	 * Returns an array of size 2 that contains the end-points.
	 * 
	 * @return Coord [] - the two end-points
	 */
	public Coord [] getEndPoints() { return new Coord [] {this.C1, this.C2}; }
	
	/**
	 * /**
	 * DOES NOT RETURN A NEW COPY OF THIS OBJECT.
	 * Use makeDeepCopy for a new instance of this object.
	 * 
	 * Returns a shallow copy of this object. 
	 * 
	 * @return Road - a shallow copy of this object
	 */
	public Road clone() { return this; }
	
	/**
	 * Returns a new instance of this object such that: 
	 * 	x.makeDeepCopy != x but x.makeDeepCopy().equals(x) is true
	 * 
	 * @return Road - a new instance of this object
	 */
	public Road makeDeepCopy() { return new Road(this.C1, this.C2); }
	
	public int hashCode() { return (this.C1.hashCode() * this.C2.hashCode()) % Integer.MAX_VALUE; }
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * Some other object is "equal to" this one iff:
	 * 	the end-points are the same.
	 */
	public boolean equals(Object o) {
		if ( !(o instanceof Road) ) return false;
		Road r = (Road) o;
		if ( r.hashCode() != this.hashCode() ) return false;
		Set<Coord> ori = new HashSet<Coord>(Arrays.asList(this.getEndPoints()));
		Set<Coord> oth = new HashSet<Coord>(Arrays.asList(r.getEndPoints()));
		ori.addAll(oth);
		return ori.size() == 2 ? true : false;
	}
	
	/**
	 * Returns a String representation of this object as: 
	 * 	ROAD (c1.x,c1.y) (c2.x,c2.y)
	 */
	public String toString() { return "ROAD " + this.C1.toString() + " " + this.C2.toString(); }
	
}
