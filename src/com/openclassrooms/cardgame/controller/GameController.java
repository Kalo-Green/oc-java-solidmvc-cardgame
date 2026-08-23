package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.View;

public class GameController {

	// --------------------------------
	// ENUM
	// --------------------------------
	// Enum qui représente l'état du jeu.
	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}

	// --------------------------------
	// ATTRIBUTS
	// --------------------------------
	Deck deck;
	List<Player> players;
	Player winner;
	View view;

	GameState gameState;

	// --------------------------------
	// CONSTRUCTEUR
	// --------------------------------
	public GameController(Deck deck, View view) {
		super();
		this.deck = deck;
		this.players = new ArrayList<Player>();
		this.view = view;

		this.gameState = GameState.AddingPlayers;
		view.setController(this);
	}

	// --------------------------------
	// METHODES
	// --------------------------------
	public void run() {
		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}

		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}

	}

	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			// Affiche le nom du joueur créé
			view.showPlayerName(players.size(), playerName);
		}
	}

	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			// On mélange le paquet.
			deck.shuffle();
			int playerIndex = 1;
			for (Player player : players) {
				// Retire une carte du paquet et l'ajoute à la main du joueur.
				player.addCardToHand(deck.removeTopCard());
				// Affiche tous les joueurs avec leur face cachée.
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		// Traite le nouvel état du jeu après la distribution des cartes.
		this.run();
	}

	// Retourne et révèle les cartes.
	public void flipCards() {
		int playerIndex = 1;
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}

		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}

	void evaluateWinner() {
		winner = new GameEvaluator().evaluateWinner(players);
	}

	void displayWinner() {
		view.showWinner(winner.getName());
	}

	void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}

}
