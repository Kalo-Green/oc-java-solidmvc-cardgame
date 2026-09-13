package com.openclassrooms.cardgame.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.openclassrooms.cardgame.controller.GameController;

//Affiche l'état du jeu sans permettre d'interagir avec lui.
//Utilise le pattern Observateur
public class GameSwingPassiveView implements GameViewable {

	// --------------------------------
	// ATTRIBUTS
	// --------------------------------
	GameController controller;
	JTextArea textArea;
	JFrame frame;

	// --------------------------------
	// METHODES
	// --------------------------------
	public void createAndShowGUI() {

		// Crée la fenêtre principale.
		frame = new JFrame("MVC-SOLID-Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// Affiche les composants verticalement.
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		addControllerCommandTracker(contentPane);

		frame.setVisible(true);
	}

	// Une zone simple permettant d'afficher ce que le Controller nous transmet.
	// Très similaire à la version en ligne de commande.
	private void addControllerCommandTracker(Container contentPane) {
		textArea = new JTextArea("Game Status\n", 100, 1);
		JScrollPane scrollPane = new JScrollPane(textArea);
		addCenteredComponent(scrollPane, contentPane);
		textArea.setSize(500, 500);
	}

	// Centre les composants horizontalement dans la zone.
	private void addCenteredComponent(JComponent component, Container contentPane) {
		component.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(component);
	}

	private void appendText(String text) {
		textArea.append(text + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	@Override
	public void setController(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void showPlayerName(int playerIndex, String playerName) {
		appendText("[" + playerIndex + "][" + playerName + "]");
	}

	@Override
	public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit) {
		appendText("[" + playerName + "][" + cardRank + ":" + cardSuit + "]");
	}

	@Override
	public void showWinner(String winnerName) {
		appendText("Winner!\n" + winnerName);
	}

	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String name) {
		appendText("[" + name + "][][]");
	}

	@Override
	public void promptForPlayerName() {
		appendText("Waiting for player name ...");
	}

	@Override
	public void promptForFlip() {
		appendText("Waiting for flipping cards ...");
	}

	@Override
	public void promptForNewGame() {
		appendText("Waiting for next step ...");
	}

}
