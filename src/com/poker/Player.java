package com.poker;

public class Player {
	// Fields
	private String playerName;
	private int index = 0;
	private Card[] cards = new Card[5];

	// getter setter
	public String getPlayerName() {
		return playerName;
	}

	// Constructor
	public Player(String playerName) {
		this.playerName = playerName;
		for (int i = 0; i < 5; i++)
			cards[i] = null;
	}

	// Replaces a card and returns the replaced card
	public Card replace(Card card, Card cardToReplaceWith) {
		Card tempCard = null;
		for (int i = 0; i <= 5; i++)
			if (cards[i].equals(card)) {
				tempCard = cards[i];
				cards[i] = cardToReplaceWith;
				return tempCard;
			}

		return null;
	}
	//Get all cards 
	public Card[] getCards()
	{
		return cards;
	}

	// Adds a card if there is a free place otherwise returns false
	public boolean add(Card cardToAdd) {
		if (index == 5)
			return false;
		for (int i = 0; i < 5; i++) {
			if (cards[i] == null) {
				cards[i] = cardToAdd;
				index++;
				return true;
			}
		}
		return false;
	}
}
