package com.openclassrooms.cardgame.model;

// Décore le joueur vainqueur en mettant son nom en évidence, tout en conservant ses fonctionnalités.
// Utilise le pattern Decorator.
public class WinningPlayer implements IPlayer {

	// --------------------------------
	// ATTRIBUT
	// --------------------------------
	IPlayer winner;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	public WinningPlayer(IPlayer player) {
		this.winner = player;
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	@Override
	public void addCardToHand(PlayingCard pc) {
		winner.addCardToHand(pc);
	}

	@Override
	public String getName() {
		return "***** " + winner.getName() + " *****";
	}

	@Override
	public PlayingCard getCard(int index) {
		return winner.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		return winner.removeCard();
	}

}
