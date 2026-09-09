package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.model.DeckFactory.DeckType;
import com.openclassrooms.cardgame.view.GameSwingView;

public class Games {

	public static void main(String[] args) {

		// Initialise l'interface graphique de l'application.
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();

		// Configure le Controller avec le paquet de cartes, la View et la règle du jeu.
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.NORMAL), gsv, new HighCardGameEvaluator());
//		GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
//		GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());
		gc.run();

	}

}
