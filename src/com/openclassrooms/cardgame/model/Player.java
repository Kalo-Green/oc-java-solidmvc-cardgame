package com.openclassrooms.cardgame.model;

public class Player {

	// --------------------------------
	// ATTRIBUTS
	// --------------------------------
	private String name;
	private Hand hand;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	public Player(String name) {
		this.name = name;
		hand = new Hand();
	}

	// --------------------------------
	// GETTER
	// --------------------------------
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	public void addCardToHand(PlayingCard pc) {
		hand.addCard(pc);
	}

	public PlayingCard removeCard() {
		return hand.removeCard();
	}
}
