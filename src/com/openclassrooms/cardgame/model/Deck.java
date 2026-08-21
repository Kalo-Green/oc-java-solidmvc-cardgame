package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	private List<PlayingCard> cards;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	// Créer les 52 cartes avec une double boulcle.
	public Deck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				System.out.println("Creating card [" + rank + "][" + suit + "]");
				cards.add(new PlayingCard(rank, suit));

			}

		}
		shuffle();
	}

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
