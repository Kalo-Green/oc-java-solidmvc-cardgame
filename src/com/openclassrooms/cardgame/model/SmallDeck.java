package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class SmallDeck extends Deck {

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	// Crée les 32 cartes du 7 à l'As avec une double boucle.
	public SmallDeck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				if (rank.value() >= 7) {
					System.out.println("Creating card: [" + rank + "][" + suit + "]");
					cards.add(new PlayingCard(rank, suit));
				}
			}
		}

		shuffle();
	}
}