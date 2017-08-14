
public abstract class Card {
	protected int numValue;
	protected String typeOf;
	protected char abbriev;
	
	public String getType() {
		return typeOf;
	}
	
	public int getNumValue() {
		return numValue;
	}
	
	public String toString() {
		
		return typeOf;
	}
	
	public char getAbbrievation() {
		return abbriev;
	}

}




class DaggerCard extends Card  {
	
	public DaggerCard() {
		this.numValue = 1;
		this.typeOf = "dagger";
		this.abbriev = (char) ((numValue + 48));
	}
	
	
}

class SwordCard extends Card {
	
	
	public SwordCard () {
		this.numValue = 2;
		this.typeOf = "sword";
		this.abbriev = (char) (numValue + 48);

	}
	
	
}

class MorningStarCard extends Card {
	
	
	public MorningStarCard () {
		this.numValue = 3;
		this.typeOf = "morning star";
		this.abbriev = (char) (numValue + 48);

	}
	
	
}
class WarAxeCard extends Card {
	
	
	public WarAxeCard() {
		this.numValue = 4;
		this.typeOf = "war axe";
		this.abbriev = (char) (numValue + 48);

	}
	
	
}
class HalberdCard extends Card {
	
	
	public HalberdCard () {
		this.numValue = 5;
		this.typeOf = "halberd";
		this.abbriev = (char) (numValue + 48);

	}
	
	
}

class LongSwordCard extends Card {
	
	
	public LongSwordCard () {
		this.numValue = 6;
		this.typeOf = "long sword";
		this.abbriev = (char) (numValue + 48);

	}
	
	
}


class ArcherCard extends Card {
	
	
	public ArcherCard () {
		this.typeOf = "archer";
		this.numValue = 7;
		this.abbriev = 'A';

	}
	
	
}

class ShieldCard extends Card {
	
	public ShieldCard() {
		this.typeOf = "shield";
		this.numValue = 0;
		this.abbriev = 'S';

	
	
	
	}

}

class CrownCard extends Card {
	
	public CrownCard() {
		this.typeOf = "Crown";
		this.numValue = -1;
		this.abbriev = 'C';
	}
	
}





