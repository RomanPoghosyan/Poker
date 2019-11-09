package com.poker;

public class Card {

	private String color;
	private String name;

	public Card(String color, String name) {
		this.color = color;
		this.name = name;
	}

	public boolean equals(Card obj) {
		if (obj.color.equals(color) && obj.name.equals(name))
			return true;
		else
			return false;
	}

}
