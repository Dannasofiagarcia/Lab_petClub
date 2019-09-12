package model;

import java.util.Comparator;

public class clubComparator implements Comparator<Club>{

	@Override
	public int compare(Club o1, Club o2) {
		return o1.getpetTypeClub().compareToIgnoreCase(o2.getpetTypeClub());
	}
	
}
