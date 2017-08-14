import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Scrimish {
	static int pileNumber = 1;
	static boolean crownKilled = false;
	static Card userCard;
	static Card compCard;
	public static void main(String[]args) {
		ArrayList<Card> totalCollection = new ArrayList<Card>(), computerTotalCollection = new ArrayList<Card>();
		ArrayList<Card> firstPile = new ArrayList<Card>(), secondPile = new ArrayList<Card>(), thirdPile = new ArrayList<Card>();
		ArrayList<Card> fourthPile = new ArrayList<Card>(), fifthPile = new ArrayList<Card>();
		ArrayList<Card> compFirstPile = new ArrayList<Card>(), compSecondPile = new ArrayList<Card>();
		ArrayList<Card> compThirdPile = new ArrayList<Card>(), compFourthPile = new ArrayList<Card>();
		ArrayList<Card> compFifthPile = new ArrayList<Card>();
		ArrayList<ArrayList<Card>> pileCollection = new ArrayList<ArrayList<Card>>();
		boolean correctCards = false;
		pileCollection.add(firstPile);
		pileCollection.add(secondPile);
		pileCollection.add(thirdPile);
		pileCollection.add(fourthPile);
		pileCollection.add(fifthPile);
		
		createCollection(totalCollection);
		copyDeck(totalCollection, computerTotalCollection);
		
		Player player = new Player(firstPile,secondPile,thirdPile,fourthPile,fifthPile);
		Computer computer = new Computer(compFirstPile,compSecondPile,compThirdPile,compFourthPile,compFifthPile);
		Scanner reader = new Scanner(System.in);
		
		computer.addPiles();
		player.addPiles();

		
		
		int chooseCompCrown =(int)Math.random() * 5;
		computer.piles.get(chooseCompCrown).add(new CrownCard());
		randomize(computer.getFirstPile(), computerTotalCollection);
		randomize(computer.getSecondPile(), computerTotalCollection);
		randomize(computer.getThirdPile(), computerTotalCollection);
		randomize(computer.getFourthPile(), computerTotalCollection);
		randomize(computer.getFifthPile(), computerTotalCollection);		
		
		boolean goodInput = false;
		boolean stringInput = false;
		String userInput = "";
		long startGame = 0;
		while(!goodInput) {

			while(!stringInput) {

				try {
					System.out.print("Press 1 to start the game, 0 to quit: ");
					userInput = reader.next();
					if(isNumber(userInput) != 10)
						stringInput = true;
					else
						System.out.println("Invalid input. Please try again.");
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid Input. Please try again.");
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input. Please try again.");
				}
			}
			startGame = isNumber(userInput);
				
				
			if(startGame != 0 && startGame != 1) {
				System.out.println("Invalid Input. Please try again.");
				stringInput = false;
				continue;
			}
		
	
			goodInput = true;
		
			
			if(startGame == 0) {
				System.out.println("Good fun!");
				System.exit(1);
			}
		}
		
		
		
		System.out.println("What is your name?");
		String name = reader.next();
		player.setName(name);
		boolean validRandom = false;
		String userRandomized = "";
		int randomized = 0;
		while(!validRandom) {
			System.out.print("Press 0 to have your cards randomized or press 1 to choose your cards: ");
			userRandomized = reader.next();
			if(isNumber(userRandomized) != 10)
				validRandom = true;
		
			randomized = isNumber(userRandomized);
			if(randomized != 0 && randomized != 1) {
				System.out.println("Invalid Input. Please try again.");
				validRandom = false;
			}
		}
		
		if(randomized == 0) {
			int crownPile = (int)(Math.random() * 5);
			pileCollection.get(crownPile).add(new CrownCard());
			randomize(player.getFirstPile(), totalCollection);
			randomize(player.getSecondPile(), totalCollection);
			randomize(player.getThirdPile(), totalCollection);
			randomize(player.getFourthPile(), totalCollection);
			randomize(player.getFifthPile(), totalCollection);
		}
		
		else {
			
			
				boolean validRandom1 = false;
				String userRandomized1 = "";
				int randomized1 = 0;
				while(!validRandom1) {
					System.out.print("Enter the number pile you want the crown card to be in: ");
					userRandomized1 = reader.next();
					if(isNumber(userRandomized1) != 10)
						validRandom1 = true;
					
					randomized1 = isNumber(userRandomized1);
					if(randomized1 < 1 || randomized1 > 5) {
						System.out.println("Invalid Input! Please input the correct number.");
						validRandom1 = false;
					}
				}
				int pileChoice = randomized1;
				player.piles.get(pileChoice).add(new CrownCard());
				
				for(int i = 0; i < 24; i++) {
					if(pileCollection.get(pileNumber-1).size() == 5)
						pileNumber++;
					System.out.println("Whole deck: ");
					printTotalCollection(totalCollection);
					System.out.println();
					Card chosenCard = findCardInCollection(totalCollection);
					while(chosenCard == null) {
						System.out.println("Card Not Found!");
						chosenCard = findCardInCollection(totalCollection);
					}
					
					player.piles.get(pileNumber-1).add(chosenCard);
					
					
					
				}
				
				
				
					
				
				
			
		}
		
		while(!crownKilled) {
			boolean wrongPile = true;
			System.out.printf("%-50s", "Computer Cards");
			System.out.println();
			printHand(computer);
			System.out.println();
			System.out.printf("%-50s", "Your Cards");
			System.out.println();
			printHand(player);
			System.out.println();
			
			
			boolean validRandom3 = false;
			String userRandomized3 = "";
			int randomized3 = 0;
			while(!validRandom3) {
				System.out.print("Press 0 to attack or 1 to discard: ");
				userRandomized3 = reader.next();
				if(isNumber(userRandomized3) != 10)
					validRandom3 = true;
				randomized3 = isNumber(userRandomized3);
				if(randomized3 != 1 && randomized3 != 0) {
					System.out.println("Invalid Input! Please input the correct number.");
					validRandom3 = false;
				}
			}
				
				int userNum = randomized3;
				 if(userNum == 1) {
					 
					 boolean validRandom4 = false;
						String userRandomized4 = "";
						int randomized4 = 0;
						while(!validRandom4) {
							System.out.print("Enter the pile number of the card you wish to discard: ");
							userRandomized4 = reader.next();
							if(isNumber(userRandomized4) != 10)
								validRandom4 = true;
							
							randomized4 = isNumber(userRandomized4);
							if(randomized4 < 1 || randomized4 > 5) {
								System.out.println("Invalid Input! Please input the correct number.");
								validRandom4 = false;
							}
							
							else if(player.piles.get(randomized4-1).get(player.piles.get(randomized4-1).size()-1).typeOf.equals("Crown")) {
								System.out.println("Cannot discard crown card. Pick another pile.");
								validRandom4 = false;
							}
						}
						player.discard(player.piles.get(randomized4-1));
						
						int compTurnComp= computer.decidePile();
						int compTurnUser = computer.chooseUserPile(player.piles);
						
						ArrayList<Card>userNumPile = player.piles.get(compTurnUser);
						ArrayList<Card>compNumPile = computer.piles.get(compTurnComp);
						
						userCard = userNumPile.get(userNumPile.size()-1);
						compCard = compNumPile.get(compNumPile.size()-1);
						System.out.println(computer.getName() + "'s " + compCard +" card in pile #" + (compTurnUser+1) + " attacked " + player.getName() + "'s " + userCard +" card!");
						
						decideAction(computer,player,compNumPile,userNumPile);
						
						
					
				}
				else {
					ArrayList<Card> userNumPile = new ArrayList<Card>();
					ArrayList<Card> compNumPile = new ArrayList<Card>();
					int compTurnComp, compTurnUser,userPile = 0,compPile = 0;
						
					while(wrongPile) {
						boolean validRandom5 = false;
						String userRandomized5 = "";
						int randomized5 = 0;
						while(!validRandom5) {
							System.out.print("Enter the pile number you want to use to attack with: ");
							userRandomized5 = reader.next();
							if(isNumber(userRandomized5) != 10)
								validRandom5 = true;
							
							randomized5 = isNumber(userRandomized5);
							if(randomized5 < 1 || randomized5 > 5) {
								System.out.println("Invalid Input! Please input the correct number.");
								validRandom5 = false;
							}
						}
						userPile = randomized5;
						
						boolean validRandom6 = false;
						String userRandomized6 = "";
						int randomized6 = 0;
						while(!validRandom6) {
							System.out.print("Enter the computer pile number you want to attack: ");
							userRandomized6 = reader.next();
							if(isNumber(userRandomized6) != 10)
								validRandom6 = true;
							randomized6 = isNumber(userRandomized6);
							if(randomized6 < 1 || randomized6 > 5) {
								System.out.println("Invalid Input! Please input the correct number.");
								validRandom6 = false;
							}
						}
						compPile = randomized6;
						
						System.out.println();
						userNumPile = player.piles.get(userPile-1);
						compNumPile = computer.piles.get(compPile-1);
						userCard = userNumPile.get(userNumPile.size()-1);
						compCard = compNumPile.get(compNumPile.size()-1);
						
						System.out.print(player.getName() + "'s Turn: " );
						System.out.println(player.getName() + "'s " + userCard + " card in pile #" + (userPile) + " attacked " + computer.getName() + "'s" + compCard+ " card in pile #" + (compPile) + "!");
						
						if(userNumPile.isEmpty() || compNumPile.isEmpty()) {
							System.out.println("No cards left in that pile!");
							
						}
						else
							wrongPile = false;
					}
						
						
					
					
		
					
					decideAction(player, computer, userNumPile, compNumPile);
					
					compTurnComp= computer.decidePile();
					compTurnUser = computer.chooseUserPile(player.piles);
					
					compCard = computer.piles.get(compTurnComp).get(computer.piles.get(compTurnComp).size()-1);
					
					ArrayList<Card>userNumPile1 = player.piles.get(compTurnUser);
					ArrayList<Card>compNumPile1 = computer.piles.get(compTurnComp);
					
					
					System.out.print("Computer Turn: " );
					System.out.println(computer.getName() + "'s " + compCard + " card in pile #" + (compTurnComp + 1) + " attacked the card in pile #" + (compTurnUser+1));
					decideAction(computer,player,compNumPile1,userNumPile1);

					
				}
			} 
			
		
		
	}
		
		
		
		
		


	
		
		
	
	
	public static void decideAction(Player attacker, Player defender, ArrayList<Card> attackPile, ArrayList<Card> defendPile) {
		Card attackerCard = attackPile.get(attackPile.size()-1);
		Card defenderCard = defendPile.get(defendPile.size()-1);
		
		switch(attacker.attack(attackPile, defendPile)) {
		
		case 0: System.out.print("Neither discard! Return cards to their respective piles.");
				break;
		 
		case 1: System.out.println(attacker.getName() + " won the battle! " + defender.getName() + " discards its " + defenderCard + " card!\n");
				defender.discard(defendPile);
				break;
				
		case 2: System.out.println("It is a tie! Both players discard their cards from their respective piles\n");
				defender.discard(defendPile);
				attacker.discard(attackPile);
				break;
		
		case 3: System.out.println(attacker.getName() + " killed " + defender.getName() + "'s crown! " + attacker.getName() + " wins!\n");
				System.exit(1);
				break;
				
		case 4: System.out.println(defender.getName() + " killed " + attacker.getName() + "'s crown! " + defender.getName() + " wins!\n");
				System.exit(1);
				break;
				
		case 5: System.out.println("Aw, " + attacker.getName() + " lost the battle! Their " + attackerCard + " card gets discarded!\n");
				attacker.discard(attackPile);
				break;		
			
			
		}	
		
	}
		
	
	
	public static void randomize(ArrayList<Card> pile, ArrayList<Card> totalCollect) {
		int nextPosition;		
		while(pile.size() < 5)
			if(totalCollect.size() != 0) {
			nextPosition = (int)(Math.random() * totalCollect.size());
			pile.add(totalCollect.get(nextPosition));
			totalCollect.remove(nextPosition);		
			}
	}

		

	
	
	public static void printArrayList(ArrayList<Card> pile) {
		
		for(int i = 0; i < pile.size(); i++) {
			System.out.printf("%-20s", pile.get(i));	
		}
		
		
	}
	
	public static void addCard(ArrayList<Card> deck, int num, Card card) {
		
		for(int i = 0; i < num; i++)
			deck.add(card);	
	}
	
	
	public static void createCollection(ArrayList<Card> totalCollection) {
		addCard(totalCollection, 5, new DaggerCard());
		addCard(totalCollection, 5, new SwordCard());
		addCard(totalCollection, 3, new MorningStarCard());
		addCard(totalCollection, 3, new WarAxeCard());
		addCard(totalCollection, 2, new HalberdCard());
		addCard(totalCollection, 2, new LongSwordCard());
		addCard(totalCollection, 2, new ShieldCard());
		addCard(totalCollection, 2, new ArcherCard());
	}
	
	public static void copyDeck(ArrayList<Card> totalCollection, ArrayList<Card> compCollection) {
		for(int i = 0; i < totalCollection.size(); i++) 
			compCollection.add(totalCollection.get(i));
		
	}
	
	
	public static void printHand(Player player) {
		
		for(int i = 0;i < player.piles.size(); i++) {
			System.out.print("Pile #" + (i+1) +": ");
			for(int j = 0; j < player.piles.get(i).size(); j++) {
				if(player instanceof Computer) 
					System.out.printf("x   ");
				else
					System.out.printf("%-20s",player.piles.get(i).get(j) + " (" + player.piles.get(i).get(j).getAbbrievation() + ")" );
			}
			
			System.out.println();
		}
		
	}
	
	public static void printTotalCollection(ArrayList<Card>totalCollection) {
		
		for(int i = 0; i < totalCollection.size(); i++) {
			if(i !=0 && i % 4 == 0)
				System.out.println();
			System.out.printf("%-20s", totalCollection.get(i)+" (" + totalCollection.get(i).getAbbrievation() + ")");
		}
		System.out.println();
		
		
	}
	
	public static Card findCardInCollection(ArrayList<Card> totalCollection) {
		Card chosenCard;
		Scanner reader = new Scanner(System.in);
		System.out.print("Type in the full name (spelling counts) of the card you want in Pile #" + pileNumber + ": ");
		String card = reader.nextLine().toLowerCase();
		
		for(int i = 0; i < totalCollection.size(); i++) {
			if(card.equals(totalCollection.get(i).getType())) {
				chosenCard = totalCollection.get(i);
				totalCollection.remove(i);
				return chosenCard;
			}
			
			
		}
		return null;
		
	}
	
	public static int isNumber(String s) {
		
		for(int i = 0; i < s.length(); i++) {
			
			if(!Character.isDigit(s.charAt(i)))
				break;
			else
				return Integer.parseInt(s);
			
		}
		
		return 10;
			
		
	}
	
	public static boolean checkForInput() {
		Scanner reader = new Scanner(System.in);
		String userInput = "";
		try {
			userInput = reader.next();
			if(isNumber(userInput) != 10)
				return true;
			else
				System.out.println("Invalid input. Please try again.");
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Input. Please try again.");
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input. Please try again.");
		}
		
			
		return false;
	}
	
	
	
	

}




