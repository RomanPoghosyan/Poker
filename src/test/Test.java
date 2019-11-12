package test;

import com.poker.Card;
import com.poker.Poker;
import com.poker.Ranks;
import com.poker.Suits;

public class Test {
    public static void main(String[] args) {
       Poker poker = new Poker(3);
       poker.anyoneWantsToChange();
       poker.showPlayersAndCards();
    }
}
