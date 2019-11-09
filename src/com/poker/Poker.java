package com.poker;

import javax.swing.*;
import java.util.ArrayList;


public class Poker {
	public static void main(String[] args)
	{
	  
	}
	
    ArrayList<Card> cards;
    Player[] players;

    public Poker(int playersCount){
        players = new Player[playersCount];

        for(int i = 0; i < playersCount; i++){
            JFrame f = new JFrame();
            String name=JOptionPane.showInputDialog(f,"Enter Name of player " + (i + 1));
            players[i] = new Player(name);
            players[i].add(cards.remove(cards.size() - 1));
        }
    }

    public void anyoneWantsToChange(){
        for(int i = 0; i < players.length; i++){
            if(playerWantsToChange(players[i])){
                Card card = null;
				players[i].replace(card, cardtoreplaceWith());
            }
        }
    }

    private Card cardtoreplaceWith() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean playerWantsToChange(Player p){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, p.getplayerName() + " would you like to change your cards?","Warning",dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
    }

}
