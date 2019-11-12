package com.poker;

import java.util.LinkedList;

public class Player {
	// Fields
	private String playerName;
	private int maxCards=4;
	private LinkedList<Card> cardList = new LinkedList<Card>();

	// Constructor Overloaded
	public Player(String playerName) {
		this.playerName = playerName;
		
	}

	public Player(String playerName, int maxCards) {
		this.playerName = playerName;
		this.maxCards =maxCards;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	

	// Replaces a card and returns the replaced card
	public Card replace(Card card, Card newCard) {
		if(cardList.removeIf(x -> x.equals(card))){
			cardList.push(newCard);
	     	return card;
	    }
		return null;
	}
	//Get all cards 
	public LinkedList<Card> getCards()
	{
		return cardList;
	}

	// Adds a card if there is a free place otherwise returns false
	public boolean addCard(Card cardToAdd) {
		if(cardList.size()==maxCards)
		return false;
		else {
			cardList.push(cardToAdd);
			return true;
		}
	}
}
