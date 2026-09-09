package com.openclassrooms.cardgame.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	protected List<PlayingCard> cards;

	// --------------------------------
	// GETTER
	// --------------------------------
	public List<PlayingCard> getCards() {
		return cards;
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.size(); i++) {
			// Échange 2 cartes dans la liste :
			// - cards : la liste des cartes
			// - i : position de la carte actuelle
			// - random.nextInt(cards.size()) : position choisie au hasard
			Collections.swap(cards, i, random.nextInt(cards.size()));

		}
	}

	public PlayingCard removeTopCard() {
		return cards.remove(0);
	}

	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}

}
