package com.poker;

public class Player {
	//Fields
	private String playerName;
	private int index=0;
	private int replaceCount=0;
	private Card[] cards = new Card[5] ;
	//getter setter 
	public String getplayerName()
	{
		return playerName;
	}
	public int getreplaceCount() { return replaceCount;}
	public boolean setreplaceCount(int n) {
		if(n>0 && n<=3)replaceCount=n;
		else {
			return false;
		}
		return true;
		
	}
   //Constructor
    public Player(String playerName)
    {   this.playerName=playerName;
    	for(int i=0;i<=5;i++)
    	cards[i]=null;
    }
	//Replaces a card and returns the replaced card
	public Card replace(Card card,Card cardtoreplaceWith)
    {  Card tempCard =null;
    	for(int i=0;i<=5;i++)
    		if(cards[i].equals(card)) {
    			tempCard=cards[i];
    			cards[i]=cardtoreplaceWith;
    			return tempCard;
    		}
    		
    	
    	return null;
    }
	//Adds a card if there is a free place otherwise returns false
    public boolean add(Card cardtoAdd)
    { if(index==5)return false;
    	for(int i=0;i<=5;i++)
    	{if(cards[i]==null)
    		{cards[i]=cardtoAdd;
    		index++;
    		return true;}
    	}
    	return false;
    }
}