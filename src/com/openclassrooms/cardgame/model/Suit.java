package com.openclassrooms.cardgame.model;

public enum Suit {

	DIAMONDS(1), HEARTS(2), SPADES(3), CLUBS(4);

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	private int suit;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	private Suit(int value) {
		suit = value;
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	public int Value() {
		return suit;
	}

}
