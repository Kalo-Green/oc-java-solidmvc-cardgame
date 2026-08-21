package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	private List<PlayingCard> cards;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	public Hand() {
		cards = new ArrayList<PlayingCard>();
	}

	// --------------------------------
	// GETTER
	// --------------------------------
	public PlayingCard getCard(int index) {
		return cards.get(index);
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	public void addCard(PlayingCard pc) {
		cards.add(pc);
	}

	public PlayingCard removeCard() {
		return cards.remove(0);
	}

}
