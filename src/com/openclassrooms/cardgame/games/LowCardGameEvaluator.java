package com.openclassrooms.cardgame.games;

import java.util.List;

import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;

public class LowCardGameEvaluator implements GameEvaluator {

	@Override
	public Player evaluateWinner(List<Player> players) {
		// Initialise les valeurs utilisées pour déterminer le meilleur joueur.
		Player bestPlayer = null;
		// Initialise le meilleur Rank trouvé.
		// -1 permet de considérer la première carte comme la meilleure.
		int bestRank = -1;
		// Initialise le meilleur Suit trouvé.
		// Utilisé pour départager les cartes ayant le même Rank.
		int bestSuit = -1;

		for (Player player : players) {
			// Indique si le joueur actuel doit devenir le nouveau meilleur joueur.
			boolean newBestPlayer = false;

			// Initialise le meilleur joueur avec le premier joueur parcouru.
			if (bestPlayer == null) {
				newBestPlayer = true;

			} else {
				// Récupère la carte du joueur actuel.
				PlayingCard pc = player.getCard(0);
				// Récupère la valeur du Rank de la carte.
				int thisRank = pc.getRank().value();

				// Compare le Rank de la carte actuelle avec le meilleur Rank trouvé.
				if (thisRank <= bestRank) {

					// Le joueur actuel devient le meilleur si son Rank est *inférieur*.
					if (thisRank < bestRank) {
						newBestPlayer = true;

					} else {

						// En cas d'égalité de Rank, compare la valeur des Suit pour départager les
						// cartes.
						if (pc.getSuit().value() < bestSuit) {
							newBestPlayer = true;
						}
					}
				}
			}

			// Met à jour le meilleur joueur et les valeurs de sa carte.
			if (newBestPlayer) {
				bestPlayer = player;
				PlayingCard pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		}

		return bestPlayer;
	}

}
