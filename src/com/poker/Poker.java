package com.poker;

import javax.swing.*;
import java.util.ArrayList;


public class Poker {
    ArrayList<Card> cards;
    Player[] players;

    public Poker(int playersCount){
        players = new Player[playersCount];

        for(int i = 0; i < playersCount; i++){
            JFrame f = new JFrame();
            String name=JOptionPane.showInputDialog(f,"Enter Name of player " + (i + 1));
            players[i] = new Player(name);
//            players[i].add(cards.remove(cards.size() - 1));
        }
    }

    public void anyoneWantsToChange(){
        for(int i = 0; i < players.length; i++){
            if(playerWantsToChange(players[i])){
                changeCards(players[i]);
            }
        }
    }

    public void changeCards(Player p){
        Object[] options = new Object[5];
        Card[] playerCards = p.getCards();
        for(int i = 0; i < playerCards.length; i++) {
            String card = playerCards[i].getSuit() + " " + playerCards[i].getRank();
            options[i] = new JCheckBox(card);
        }

        JOptionPane.showOptionDialog(null, "Which cards do you want to replace?",
                "Replace!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

        for(int i = 0; i < options.length; i++) {
            if (((JCheckBox)options[i]).isSelected()) {
                p.replace(playerCards[i], cards.remove(cards.size() - 1));
            }
        }
    }

    public boolean playerWantsToChange(Player p){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, p.getPlayerName() + " would you like to change your cards?","Warning",dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
