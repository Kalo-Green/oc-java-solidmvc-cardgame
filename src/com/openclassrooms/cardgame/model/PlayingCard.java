package com.openclassrooms.cardgame.model;

public class PlayingCard {

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	private Rank rank;
	private Suit suit;
	// Indique si la carte est face visible (true) ou face cachée (false).
	private boolean faceUp;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	public PlayingCard(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	// Pas de setters : le rang et la couleur d'une carte ne peuvent pas être
	// modifiés après sa création.
	// --------------------------------
	// GETTERS
	// --------------------------------
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	// Inverse l'état de la carte : face visible -> face cachée.
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

}
