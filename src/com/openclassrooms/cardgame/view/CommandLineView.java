package com.openclassrooms.cardgame.view;

import java.util.Scanner;

import com.openclassrooms.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {

	// --------------------------------
	// ATTRIBUTS
	// --------------------------------
	private GameController controller;
	private Scanner keyboard = new Scanner(System.in);

	// --------------------------------
	// METHODES
	// --------------------------------
	// Associe le Controller à la View pour permettre leur communication.
	public void setController(GameController gc) {
		this.controller = gc;
	}

	public void promptForPlayerName() {
		System.out.println("Enter Player Name:");
		String name = keyboard.nextLine();
		// Un nom vide indique qu'il n'y a plus de joueur à ajouter.
		if (name.isEmpty()) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	}

	public void promptForFlip() {
		System.out.println("Press enter to reveal cards");
		// Attend l'appui sur Entrée avant de retourner les cartes.
		keyboard.nextLine();
		controller.flipCards();
	}

	public void promptForNewGame() {
		System.out.println("Press enter to deal again");
		keyboard.nextLine();
		controller.startGame();
	}

	public void showWinner(String playerName) {
		System.out.println("Winner is " + playerName + " !");
	}

	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("[" + playerIndex + "][" + playerName + "]");
	}

	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("[" + playerIndex + "][" + playerName + "][x][x]");
	}

	public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
		System.out.println("[" + playerIndex + "][" + playerName + "][" + rank + "][" + suit + "]");
	}
}
