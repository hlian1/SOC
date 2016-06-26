package sm;

import java.util.Vector;

import enums.DevType;
import objects.*;

public class SM {
	
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
}
