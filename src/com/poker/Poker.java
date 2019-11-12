package com.poker;

import javax.swing.*;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.util.Collection;
import java.util.LinkedList;


public class Poker {
    LinkedList<Card> cards = new LinkedList<>();
    LinkedList<Card> bat = new LinkedList<>();
    LinkedList<Player> players;

    public Poker(int playersCount) {
        players = new LinkedList<Player>();

        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        cards = shuffleCards(cards);

        for (int i = 0; i < playersCount; i++) {
            JFrame f = new JFrame();
            String name = JOptionPane.showInputDialog(f, "Enter Name of player " + (i + 1));
            Player p = new Player(name);
            for (int j = 0; j < 5; j++) {
                p.addCard(cards.remove(cards.size() - 1));
            }
            players.push(p);
        }
    }

    public void anyoneWantsToChange() {
        for (Player player : players)
            if (playerWantsToChange(player))
                changeCards(player);
    }

    public void changeCards(Player p) {
        LinkedList<Object> options = new LinkedList<>();
        LinkedList<Card> playerCards = p.getCards();
        for (Card card : playerCards) {
            String cardString = card.getSuit() + " " + card.getRank();
            options.add(new JCheckBox(cardString));
        }

        options.add("Ok");

        JOptionPane.showOptionDialog(null, "Which cards do you want to replace?", "Replace!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options.toArray(), null);

        options.remove(options.size() - 1);
        for (Object option : options) {
            int i = 0;
            if (((JCheckBox) option).isSelected()) {
                bat.add(playerCards.get(i));
                p.replace(playerCards.get(i), cards.remove(cards.size() - 1));
            }
            i++;

        }

    }

    public boolean playerWantsToChange(Player p) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, p.getPlayerName() + " would you like to change your cards?", "Warning", dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public LinkedList<Card> shuffleCards(LinkedList<Card> cards){
    	java.util.Collections.shuffle(cards);
    	return cards;
    }

    public void showPlayersAndCards(){
        for (Player player : players){
            System.out.println(player.getPlayerName());
            for(Card c : player.getCards()){
                System.out.print(c.getRank() + " " + c.getSuit() + ", ");
            }
            System.out.println();
        }
    }
}
