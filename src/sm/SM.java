package sm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import enums.DevType;
import enums.Resource;
import objects.Coord;
import objects.DevCard;
import objects.ResHex;

public class SM {
	
	private static Resource [] NORM_RESOURCES = {
		Resource.WHEAT, Resource.WHEAT, Resource.WHEAT, Resource.WHEAT, Resource.WHEAT,
		Resource.WOOD, Resource.WOOD, Resource.WOOD, Resource.WOOD, Resource.WOOD, 
		Resource.WOOL, Resource.WOOL, Resource.WOOL, Resource.WOOL, Resource.WOOL, 
		Resource.ORE, Resource.ORE, Resource.ORE, 
		Resource.BRICK, Resource.BRICK, Resource.BRICK,
		Resource.DESERT
	}; 
	
	private static Resource [] EXP_RESOURCES = {
		Resource.WHEAT, Resource.WHEAT, Resource.WHEAT, Resource.WHEAT, Resource.WHEAT,
		Resource.WOOD, Resource.WOOD, Resource.WOOD, Resource.WOOD, Resource.WOOD, 
		Resource.WOOL, Resource.WOOL, Resource.WOOL, Resource.WOOL, Resource.WOOL, 
		Resource.ORE, Resource.ORE, Resource.ORE, 
		Resource.BRICK, Resource.BRICK, Resource.BRICK,
		Resource.ANY, Resource.ANY, 
		Resource.DESERT 
	};
	
	private static Integer [] DICE = {
		6, 6, 8, 8, 9, 9, 5, 5, 4, 4, 10, 10, 11, 11, 3, 3, 12, 2 	
	};
	
	public static int getUsedDevCards(Vector<DevCard> c) {
		int count = 0;
		for ( DevCard d : c ) if (d.isUsed()) count++;
		return count;
	}

	public static int getUsedDevCards(Vector<DevCard> dev, DevType t) {
		int count = 0;
		for ( DevCard d : dev ) if ( d.isUsed() && d.getType() == t ) count++;
		return count;
	}

	public static int getNumDevCard(Vector<DevCard> dev, DevType t) {
		int count = 0;
		for ( DevCard d : dev ) if ( d.getType() == t ) count++;
		return count;
	}
	
	public static int getNumHex(int size) {
		return 3 * size * (size - 1) + 1;
	}

	public static Coord moveHexUp(Coord c) {
		Coord o = c.makeDeepCopy();
		o.shiftXY(1, 2); 
		return o;
	}
	
	public static Coord moveHexBottomRight(Coord c) {
		Coord o = c.makeDeepCopy();
		o.shiftXY(1, -1);
		return o;
	}
	
	public static Coord moveHexUpRight(Coord c) {
		Coord o = c.makeDeepCopy();
		o.shiftXY(2,1);
		return o;
	}
	
	public static int [] calcNumHexPerCol(int size) {
		int total = 2 * size - 1;
		int [] offsets = new int[total];
		for ( int i = 0; i < total; i++ ) {
			offsets[i] = size + i;
		}
		return null;
	}
	
	public static Vector<ResHex> generateHexagons(int size) {
		Vector<ResHex> res = new Vector<ResHex>();
		
		int numHex = getNumHex(size);
		
		List<Resource> resources = Arrays.asList(NORM_RESOURCES);
		int resLimit = resources.size();
		Collections.shuffle(resources);
		
		List<Integer> die = Arrays.asList(DICE);
		int dieLimit = die.size();
		Collections.shuffle(die);
		
		Coord init = new Coord(1, size);
		
		for ( int i = 0; i < numHex; i++ ) {
			ResHex r = new ResHex(init, 
								  resources.get(i % resLimit), 
								  die.get(i % dieLimit));
		}
		
		return res;
	}
}
