package model;

import java.util.Comparator;

public class ownerComparator implements Comparator<Owner> {

	@Override
	public int compare(Owner o1, Owner o2) {
		return o1.getPetTypeOwner().compareToIgnoreCase(o2.getPetTypeOwner());
	}
}
