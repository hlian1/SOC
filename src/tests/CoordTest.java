package tests;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import objects.Coord;

/**
 * This java file is to be used to test the Coord objects.
 * 
 * @author Hau Lian
 * @version Sunday, June 12th, 2016 19:06
 *
 */
public class CoordTest {
	
	@Test
	public void equalsTest() {
		Coord a = new Coord(1,1), b = new Coord(1,1), c = new Coord(2,2);
		
		assertEquals(a,b);
		assertThat(a, not(c));
		assertThat(b, not(c));
		
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		
		assertFalse(a.equals(c));
		assertFalse(c.equals(a));
		
		assertFalse(a.equals(null));
		assertFalse(c.equals(null));
		
		assertFalse(a.equals(""));
	}
	
	@Test
	public void shiftTest() {
		Coord a = new Coord(1,1), b = new Coord(1,1), c = new Coord(2,2);
		
		assertEquals(a,b);
		
		a.shiftX(3);
		b.shiftY(5);
		
		assertFalse(a.equals(b));
		
		c.shiftXY(2, -1);
		
		assertEquals(a,c);
		
		
		
	}
	
	@Test
	public void mutabilityTest() {
		
	}

}
