package com.poker;
import java.util.Random;
import java.util.ArrayList;
public class Poker {
  

      public class Card {

    		private short rank, suit;
		 
		    private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };

		    private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		
		        Card (short suit, short rank){
			
		            this.rank=rank;
		
		             this.suit=suit;
	         }
        
}
