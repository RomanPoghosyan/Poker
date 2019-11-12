package com.poker;

public enum Suits {
    CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");
    private String value;
    Suits(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
