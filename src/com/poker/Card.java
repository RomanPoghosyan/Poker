package com.poker;

public class Card {
<<<<<<< HEAD

=======
>>>>>>> a676cab1b726a66d0a72fdce1cd53796b7a9615e
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
<<<<<<< HEAD

=======
>>>>>>> a676cab1b726a66d0a72fdce1cd53796b7a9615e
}
