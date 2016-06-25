package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import objects.Coord;

public class SpeedTest {
	
	@Test
	public void instanceofVTryCatchSpeedTest() {
		
		ArrayList<Coord> objs = new ArrayList<Coord>();
		ArrayList<String> words = new ArrayList<String>();
		
		for ( int i = 0; i < 10000000; i++ ) {
			objs.add(new Coord(5,6));
			words.add("The quick brown fox jumped over the clouds");
		}
		
		long s = System.currentTimeMillis();
		for ( int k = 0; k < 10000000; k++ ) {
			objs.get(k).equals(words.get(k));
		}
		for ( int k = 0; k < 10000000; k++ ) {
			objs.get(k).equals(objs.get(k));
		}
		long e = System.currentTimeMillis();
		System.out.println((e-s)/1000.0);
	}

}
