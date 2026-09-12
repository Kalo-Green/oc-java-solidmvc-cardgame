package com.openclassrooms.cardgame.model;

public interface IPlayer {

	void addCardToHand(PlayingCard pc);

	PlayingCard getCard(int i);

	PlayingCard removeCard();

	String getName();

}
