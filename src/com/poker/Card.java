package com.poker;

public class Card {

	private Suits suit;
	private Ranks rank;

	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public boolean equals(Card obj) {
		return (obj.suit.equals(suit) && obj.rank.equals(rank));
	}

	public String getSuit() {
		return suit.toString();
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank.toString();
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}
}
