package com.poker;

import javax.swing.*;
import java.util.LinkedList;


public class Poker {
    LinkedList<Card> cards = new LinkedList<Card>();
    LinkedList<Player> players;

    public Poker(int playersCount){
        players = new LinkedList<Player>();

        for ( Suits suit : Suits.values() ) {
            for (Ranks rank : Ranks.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        for(int i = 0; i < playersCount; i++){
            JFrame f = new JFrame();
            String name=JOptionPane.showInputDialog(f,"Enter Name of player " + (i + 1));
            players.push(new Player(name));
            for(int j = 0; j < 5; j++)
                players.getLast().add(cards.remove(cards.size() - 1));
        }
    }

    public void anyoneWantsToChange(){
      for (Player player : players) 
            if(playerWantsToChange(player))
            	changeCards(player);
    }

    public void changeCards(Player p){
        LinkedList<Object> options = new LinkedList<Object>();
        LinkedList<Card> playerCards = p.getCards();
           for (Card card : playerCards) {
        	   String cardString =card.getSuit() + " " + card.getRank();
               options.push(new JCheckBox(cardString));      
		}
            

        JOptionPane.showOptionDialog(null, "Which cards do you want to replace?",
                "Replace!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options.toArray(), options.getFirst());

        for (Object option : options) {
        	int i=0;
            if (((JCheckBox)option).isSelected()) {
                p.replace(playerCards.get(i), cards.remove(cards.size() - 1));
            }
            i++;
        	
		} 
        
    }

    public boolean playerWantsToChange(Player p){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, p.getPlayerName() + " would you like to change your cards?","Warning",dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
