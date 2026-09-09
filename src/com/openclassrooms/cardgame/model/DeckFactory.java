package com.openclassrooms.cardgame.model;

/**
 * Factory permettant de sélectionner et de créer le type de deck demandé.
 */
public class DeckFactory {

	public enum DeckType {
		NORMAL, SMALL, TEST
	}

	public static Deck makeDeck(DeckType type) {
		switch (type) {
		case NORMAL:
			return new NormalDeck();
		case SMALL:
			return new SmallDeck();
		case TEST:
			return new TestDeck();
		}
		return new NormalDeck();
	}

}
