package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.model.DeckFactory.DeckType;
import com.openclassrooms.cardgame.view.GameSwingPassiveView;
import com.openclassrooms.cardgame.view.GameSwingView;
import com.openclassrooms.cardgame.view.GameViewables;

public class Games {

	public static void main(String[] args) {

		// Regroupe les différentes vues utilisées par le jeu.
		GameViewables views = new GameViewables();

		// Initialise et affiche l'interface graphique de l'application.
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();

		views.addViewable(gsv);

		// Crée plusieurs vues passives pour afficher les informations du jeu.
		for (int i = 0; i < 3; i++) {
			GameSwingPassiveView passiveView = new GameSwingPassiveView();
			passiveView.createAndShowGUI();

			views.addViewable(passiveView);

			// Attend entre chaque création de fenêtre pour permettre de les positionner
			// avant le début de la partie.
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Configure le Controller avec le paquet de cartes, les vues et la règle du
		// jeu.
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.NORMAL), views,
				new HighCardGameEvaluator());
//		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.NORMAL), views,
//				new LowCardGameEvaluator());
//		GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
//		GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());
		gc.run();

	}

}
