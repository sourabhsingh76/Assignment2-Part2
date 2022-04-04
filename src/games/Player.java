package games;

import java.util.ArrayList;

public class Player {
	String name;
	boolean s = false; // s represents spade, f represents face
	boolean f = false; // initially, player don’t have spade and face cards so s, f is initialized as
						// false

	ArrayList<Card> c = new ArrayList<Card>(); // declaring an ArrayList of type Card

	public Player(String name) { // constructor
		super();
		this.name = name;
	}

	public void addCard(Card card) {
		c.add(card);
	}

	public ArrayList<Card> getCards() {
		return c;
	}

	@Override
	public String toString() {
		return name;
	}
}
