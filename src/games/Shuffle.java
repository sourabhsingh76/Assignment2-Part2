package games;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
	public void shuffle_cards(ArrayList<Card> cards) {
		Random rand = new Random();
		for (int i = 0; i < cards.size(); i++) { // shuffling cards
			int r = i + rand.nextInt(cards.size() - i); // getting value of r in the range from 0 to cards.size()-i

			// swapping the elements
			Card temp = cards.get(r);
			cards.set(r, cards.get(i));
			cards.set(i, temp);
		}

	}

}
