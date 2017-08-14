import java.util.ArrayList;
public class Player {
	ArrayList<ArrayList<Card>> piles = new ArrayList<ArrayList<Card>>();
	private ArrayList<Card> firstPile = new ArrayList<Card>();
	private ArrayList<Card> secondPile = new ArrayList<Card>();
	private ArrayList<Card> thirdPile = new ArrayList<Card>();
	private ArrayList<Card> fourthPile = new ArrayList<Card>();
	private ArrayList<Card> fifthPile = new ArrayList<Card>();
	private String name;

	public Player(ArrayList<Card> firstPile, ArrayList<Card> secondPile, ArrayList<Card> thirdPile, ArrayList<Card> fourthPile, ArrayList<Card> fifthPile) {
		this.firstPile = firstPile;
		this.secondPile = secondPile;
		this.thirdPile = thirdPile;
		this.fourthPile = fourthPile;
		this.fifthPile = fifthPile;	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
	public int attack(ArrayList<Card> pile, ArrayList<Card> oppPile)  {
		Card userCard = pile.get(pile.size()-1);
		Card oppCard = oppPile.get(oppPile.size()-1);
		int userNum = userCard.getNumValue();
		int oppNum = oppCard.getNumValue();
		
		
		
		/*Archer Card: If you attack with an Archer Card, it always wins. 
		 * If your Archer Card is attacked, it always loses.Shield Card: Shield Cards cannot be used to attack. 
		 * If your Shield Card is attacked, both your Shield Card and your opponent's attacking Card are discarded (except for Archer Cards: 
		 * If a Shield Card is attacked by an Archer Card, neither Card is discarded, and both are returned face down to their original Piles).
			Crown Card: You can attack with your Crown Card. If you attack your opponent's Crown Card, you win. Otherwise, you lose the game.
			Instead of attacking, you may intentionally discard one Card on your turn. You do not have to reveal that Card to your opponent. 
			You cannot intentionally discard your Crown Card.*/
		
		
		if(oppNum == -1)
			return 3;
		
		if(userNum == -1)
			return 4; //lose game
		
		if(userNum == 7) //if archer card
			if(oppNum == 0)
				return 0; //neither discard
			else if (oppNum == -1)
				return 3; //win game
			else
				return 1; //user wins, opponent discard
		
		if(oppNum == 7)
			return 1; //user wins, opponent discard
		
		if(oppNum == 0)
			return 2; //both discard
		
		if(userNum > oppNum)
			return 1;
		else if(userNum == oppNum)
			return 2;
		else
			return 5; //user loses, user discard
			
		
	}
		
		
	
	public void discard(ArrayList<Card> pile) {
		pile.remove(pile.size()-1);
		
	}
	
	

	
	
	public ArrayList<Card> getFirstPile() {
		
		return firstPile;
	}
	
	public ArrayList<Card> getSecondPile() {
		
		return secondPile;
	}
	
	public ArrayList<Card> getThirdPile() {
		return thirdPile;
	}
	
	
	public ArrayList<Card> getFourthPile() {
		return fourthPile;
	
	}
	
	public ArrayList<Card> getFifthPile() {
		return fifthPile;
	}
	
	
	public void addPiles() {
		piles.add(firstPile);
		piles.add(secondPile);
		piles.add(thirdPile);
		piles.add(fourthPile);
		piles.add(fifthPile);

		
	}
	
	
	
	
	
	
	
}


class Computer extends Player {
	
	public Computer(ArrayList<Card> firstPile, ArrayList<Card> secondPile, ArrayList<Card> thirdPile, ArrayList<Card> fourthPile, ArrayList<Card> fifthPile) {
		super(firstPile,secondPile,thirdPile,fourthPile,fifthPile);
		super.setName("HAL"); 
	}
	
	public int decidePile() {
		int highPile = 0;
		Card highCard = null;
		for(int i = 0; i < piles.size(); i ++) {
			if(!piles.get(i).isEmpty()) {
				highCard = piles.get(i).get(piles.get(i).size()-1);
				break;
			}
				
			
		}
		
		Card currentCard;
		int currentNum;
		
		for(int i = 0; i <piles.size(); i++) {
			int highNum = highCard.getNumValue();
			if(!piles.get(i).isEmpty()) {
				currentCard = piles.get(i).get(piles.get(i).size()-1);
				currentNum = currentCard.getNumValue();
			
				if(currentNum > highNum) {
					highPile = i;
					highCard = currentCard;
				}
			}
			
			
		}
		
		return highPile;
		
			
	}
	
	
	public int chooseUserPile(ArrayList<ArrayList<Card>> piles) {
		boolean validPile = false;
		int chosenPile = 0;
		while(!validPile) {
		chosenPile = (int)(Math.random() * 5);
		if(!piles.get(chosenPile).isEmpty())
			
			validPile = true;
		
		
		}
		
		return chosenPile;
		
		
		
	}
	
	

}



