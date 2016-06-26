package objects;

import enums.Resource;

/**
 * Provides a Resource Card for Settler of Catan.
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 1149
 *
 */
public class ResCard {

	/**
	 * Resource type of this card
	 */
	private final Resource r;
	
	/**
	 * Creates a new Resource Card object with the specified resource.
	 * 
	 * @param r - the type of resource for this card
	 */
	public ResCard(Resource r) {
		this.r = r;
	}
	
	/**
	 * Returns the type of this resource card.
	 * 
	 * @return Resource - the resource type of the card
	 */
	public Resource getType() { return this.r; }
	
	/**
	 * DOES NOT RETURN A NEW COPY OF THIS OBJECT.
	 * Use makeDeepCopy for a new instance of this object.
	 * 
	 * Returns a shallow copy of this object. 
	 * 
	 * @return ResCard - a shallow copy of this instance
	 */
	public ResCard clone() { return this; }
	
	/**
	 * Returns a new instance of this object such that: 
	 * 	x.makeDeepCopy != x but x.makeDeepCopy().equals(x) is true
	 * 
	 * @return ResCard - a clone of this instance.
	 */
	public ResCard makeDeepCopy() { return new ResCard(this.r); }
	
	public int hashCode() { return this.r.ordinal(); }
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * Some other object is "equal to" this one iff:
	 * 	the resource are the same.
	 */
	public boolean equals(Object o) {
		if ( !(o instanceof ResCard) ) return false;
		return this.r == ((ResCard) o).r;
	}
	
	/**
	 * Returns a String representation of this object as: 
	 * 	CARD RESOURCE [resource]
	 */
	public String toString() { return "CARD RESOURCE " + this.r.toString(); }
}
