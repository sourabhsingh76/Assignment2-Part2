package games;

import java.util.ArrayList;

public class CardsGame {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>(); // declaring an ArrayList of type Player
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));

		ArrayList<Card> cards = new ArrayList<Card>(); // declaring an ArrayList of type Card

		String[] name = { "s", "h", "d", "c" }; // s represents spade, h represents heart, d represents diamond, c
												// represents club

		for (String n : name) { // adding 52 playing cards in the ArrayList of cards
			for (int card_number = 1; card_number <= 13; card_number++) {
				cards.add(new Card(n, card_number));
			}
		}

		Shuffle shuffle = new Shuffle(); // declaring an instance of Shuffle class
		shuffle.shuffle_cards(cards); // shuffling the cards

		ArrayList<Integer> remainingCards = new ArrayList<Integer>(); // remainingCards ArrayList will store 0 and 1, 0
																		// means card is not given to any player, 1
																		// means card is given to a player

		for (int i = 0; i < cards.size(); i++) {
			remainingCards.add(0); // initially, all the elements of remainingCards ArrayList are 0
		}

		int p = 0; // p represents no. of used cards to satisfy condition
		for (int i = 0; i < remainingCards.size(); i++) {
			System.out.print(remainingCards.get(i));
			if (remainingCards.get(i) == 1) {
				p++;
			}
		}
		System.out.println();
		System.out.println("Initially, no. of used cards : " + p);

		System.out.println();

		ArrayList<Integer> sfCount = new ArrayList<Integer>(); // sfCount ArrayList represents count of cards contained
																// by each player which has been used to satisfy the
																// condition of getting at least 1 spade and face card
		for (int i = 0; i < 4; i++) { // index of sfCount ArrayList represents player number
			sfCount.add(0);
		}

		for (int i = 0; i < cards.size(); i++) { // traversing the ArrayList of cards

			if ((cards.get(i).name == "s") && (cards.get(i).number >= 11 || cards.get(i).number == 1)) { // if card is
																											// like King
																											// of spade
				for (int j = 0; j < players.size(); j++) { // traversing the ArrayList of players
					if (players.get(j).s == false || players.get(j).f == false) { // checking for each player whether it
																					// has spade, face card or not
						players.get(j).addCard(cards.get(i));
						players.get(j).s = true;
						players.get(j).f = true;
						remainingCards.set(i, 1); // after giving card to player, change element value of ith index to 1
													// in remainingCards ArrayList
						int x = sfCount.get(j) + 1;
						sfCount.set(j, x); // update the sfCount ArrayList
						break;
					}
				}
			} else if (cards.get(i).name == "s") {
				for (int j = 0; j < players.size(); j++) {
					if (players.get(j).s == false) {
						players.get(j).addCard(cards.get(i));
						players.get(j).s = true;
						remainingCards.set(i, 1);
						int x = sfCount.get(j) + 1;
						sfCount.set(j, x);
						break;
					}
				}
			} else if (cards.get(i).number >= 11 || cards.get(i).number == 1) {
				for (int j = 0; j < players.size(); j++) {
					if (players.get(j).f == false) {
						players.get(j).addCard(cards.get(i));
						players.get(j).f = true;
						remainingCards.set(i, 1);
						int x = sfCount.get(j) + 1;
						sfCount.set(j, x);
						break;
					}
				}
			}

		}

		p = 0;
		for (int i = 0; i < remainingCards.size(); i++) {
			System.out.print(remainingCards.get(i));
			if (remainingCards.get(i) == 1) {
				p++;
			}
		}
		System.out.println();
		System.out.println("no. of used cards while traversing the ArrayList to satisfy condition : " + p);

		System.out.println();

		for (int i = 0; i < sfCount.size(); i++) {
			System.out.println("cards contained by " + players.get(i).toString() + " to satisfy condition" + " = "
					+ sfCount.get(i) + ","); // count of cards contained by each player which has been used to satisfy
			// the condition of getting at least 1 spade and face card
		}

		for (int i = 0; i < players.size(); i++) { // printing cards contained by each player
			System.out.print(players.get(i).toString() + " : ");
			System.out.println(players.get(i).getCards());
		}

		System.out.println();

		for (int i = 0; i < sfCount.size(); i++) { // we will give the card to those players(which used only 1 card to
													// satisfy the condition of getting at least 1 spade and face card)
													// so that all players can have 2 cards each so we can assign
													// remaining 11 cards to each player uniformly
			if (sfCount.get(i) == 1) {
				for (int j = 0; j < remainingCards.size(); j++) {
					if (remainingCards.get(j) == 0) {
						players.get(i).addCard(cards.get(j));
						remainingCards.set(j, 1); // after giving card to player, change element value of ith index to 1
													// in remainingCards ArrayList
						break;
					}
				}
			}
		}

		p = 0;
		for (int i = 0; i < cards.size(); i++) {
			System.out.print(remainingCards.get(i));
			if (remainingCards.get(i) == 1) {
				p++;
			}
		}
		System.out.println();
		System.out.println("no. of used cards : " + p);

		for (int i = 0; i < players.size(); i++) { // printing cards contained by each player till here
			System.out.print(players.get(i).toString() + " : ");
			System.out.println(players.get(i).getCards());
		}
		System.out.println();

		int curr = 0; // assign all the remaining cards to players(11 cards to each player)
		for (int i = 0; i < cards.size(); i++) {
			if (remainingCards.get(i) == 0) {
				players.get(curr).addCard(cards.get(i));
				curr = (curr + 1) % 4;
			}
		}

		System.out.println("Finally, cards contained by each player are shown below : ");

		for (int i = 0; i < players.size(); i++) { // printing cards contained by each player
			System.out.print(players.get(i).toString() + " : ");
			System.out.println(players.get(i).getCards());
			// System.out.println(players.get(i).c.size());
		}

	}

}
