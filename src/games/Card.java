package games;

public class Card {
	String name;
	int number;

	public Card(String name, int number) { // Constructor
		this.name = name;
		this.number = number;

	}

	@Override
	public String toString() {
		return name + number;
	}
}
