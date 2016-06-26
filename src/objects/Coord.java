package objects;

/**
 * Provides a Cartesian coordinate in the form (x,y).
 * 
 * The objects of this class are mutable by default.  
 * But can be made immutable during initialization or by calling a method.
 * 
 * NOTE: The hashCode() method has limitations.
 * 
 * @author Hau Lian
 * @version Sunday, June 26th, 2016 0953
 *
 */
public class Coord {
	
	/**
	 * Private integer holding the X value of the coordinate.
	 */
	private int x;
	
	/**
	 * Private integer holding the Y value of the coordinate.
	 */
	private int y;
	
	/**
	 * Private boolean indicating if this object is mutable.
	 */
	private boolean isMutable;
	
	/**
	 * Constructs a new Coord object.  This object is mutable by default.
	 * 
	 * @param x - the integer representing the X value
	 * @param y - the integer representing the Y value
	 */
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
		this.isMutable = true;
	}
	
	/**
	 * Constructs a new Coord object.
	 * 
	 * @param x - the integer representing the X value
	 * @param y - the integer representing the Y value
	 * @param isMutable - boolean representing the mutability of this object
	 */
	public Coord(int x, int y, boolean isMutable) {
		this.x = x;
		this.y = y;
		this.isMutable = isMutable;
	}
	
	/**
	 * Returns the X value of this coordinate.
	 * 
	 * @return int - the X coordinate value
	 */
	public int getX() { return this.x; }
	
	/**
	 * Return the Y value of this coordinate.
	 * 
	 * @return int - the Y coordinate value
	 */
	public int getY() { return this.y; }
	
	/**
	 * Returns the X and Y values in an integer array.
	 * 
	 * @return int [] in the form [x, y]
	 */
	public int [] getCoordinates() { return new int [] {this.x, this.y}; } 
	
	/**
	 * Returns the mutability of this object
	 * 
	 * @return boolean representing the mutability of this object
	 */
	public boolean isMutable() { return this.isMutable; }
	
	/**
	 * Moves this objects X position by the specified amount.
	 * If the object is immutable a system message will be printed.
	 * 
	 * @param dX - an integer representing the shift in X position
	 */
	public void shiftX(int dX) { 
		if (this.isMutable) this.x += dX; 
		else System.out.println("Object is immutable.  X-value is unchanged.");
	}
	
	/**
	 * Moves this objects Y position by the specified amount.
	 * If the object is immutable a system message will be printed.
	 * 
	 * @param dY - an integer representing the shift in Y position
	 */
	public void shiftY(int dY) { 
		if (this.isMutable) this.y += dY; 
		else System.out.println("Object is immutable.  Y-value is unchanged.");
	}
	
	/**
	 * Moves this objects X and Y positions by the respective specified amounts.
	 * If the object is immutable a system message will be printed.
	 * 
	 * @param dX - an integer representing the shift in X position
	 * @param dY = an integer representing the shift in Y position
	 */
	public void shiftXY(int dX, int dY) { 
		if (this.isMutable) {
			this.x += dX; 
			this.y += dY; 
		} else 
			System.out.println("Object is immutable.  XY-values are unchanged.");
	}
	
	/**
	 * Makes this object immutable
	 */
	public void makeImmutable() { this.isMutable = false; }
	
	/**
	 * Returns a reference to this object if it is mutable.
	 * Otherwise, it will return a new instance of this object such that:
	 * 		newInstance.equals(this) is true.
	 */
	public Coord clone() { 
		if (this.isMutable) return this; 
		else return makeDeepCopy();
	}
	
	/**
	 * Returns a new instance of this object such that:
	 * 		newInstance.equals(this) is true.
	 * 
	 * @return Coord - a new instance of this object
	 */
	public Coord makeDeepCopy() { return new Coord(this.x, this.y); }
	
	/**
	 * Indicates whether this object is equal to 'o'
	 * 
	 * An object is equal to this object iff:
	 * 		o is an instance of Coord 	AND
	 * 		this.x equals o.x			AND
	 * 		this.y equals o.y
	 */
	public boolean equals(Object o) {
		if (! (o instanceof Coord) ) return false;
		Coord c = (Coord) o;
		if ( this.hashCode() != c.hashCode() ) return false;
		return this.x == c.x && this.y == c.y;
	}
	
	/**
	 * Returns a hash code value of the object.  
	 * This integer is guaranteed to be unique for the points:
	 * 	( [-32719, 32719] , [-32717, 32717] )
	 */
	public int hashCode() {
		return 32719*this.x + 32717*this.y;
	}
	
	/**
	 * Returns the String representation of this object in the form:
	 * 	"(x,y)"
	 */
	public String toString() { return "(" + this.x + "," + this.y + ")"; }
	
}
