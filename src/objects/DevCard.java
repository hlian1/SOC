package objects;

import enums.DevType;

/**
 * Provides a Development Card for Settler of Catan.
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 1149
 *
 */
public class DevCard {
	
	/**
	 * Development type of this card.
	 */
	private final DevType t;
	
	/**
	 * Boolean variable.  True if the card has been used.
	 */
	private boolean isUsed = false;
	
	/**
	 * Creates a new Development Card object with the specified type.
	 * 
	 * @param t - the type of development
	 */
	public DevCard(DevType t) {
		this.t= t;
	}
	
	/**
	 * Returns the type of development of this card.
	 * 
	 * @return DevType - the development type
	 */
	public DevType getType() { return this.t; }
	
	/**
	 * Returns if this development card has been used.
	 * 
	 * @return boolean - true if this card has been used,
	 * 						false otherwise.
	 */
	public boolean isUsed() { return this.isUsed; }
	
	/**
	 * Uses the card.
	 */
	public void use() { this.isUsed = true; }
	
	/**
	 * DOES NOT RETURN A NEW COPY OF THIS OBJECT.
	 * Use makeDeepCopy for a new instance of this object.
	 * 
	 * Returns a shallow copy of this object. 
	 * 
	 * @return DevCard - a shallow copy of this object
	 */
	public DevCard clone() { return this; }
	
	/**
	 * Returns a new instance of this object such that: 
	 * 	x.makeDeepCopy != x but x.makeDeepCopy().equals(x) is true
	 * 
	 * @return DevCard - a clone of this instance.
	 */
	public DevCard makeDeepCopy() { return new DevCard(this.t); }
	
	public int hashCode() { return this.t.ordinal(); }
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * Some other object is "equal to" this one iff:
	 * 	the development types are the same.
	 */
	public boolean equals(Object o) {
		if ( !(o instanceof DevCard) ) return false;
		return this.t == ((DevCard) o).t;
	}
	
	/**
	 * Returns a String representation of this object as: 
	 * 	CARD DEV [type]
	 */
	public String toString() { return "CARD DEV " + this.t.toString(); }
}
