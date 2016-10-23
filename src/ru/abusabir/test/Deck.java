package ru.abusabir.test;

import java.util.LinkedList;

/**
 * Oleg
 * 23.10.2016
 */
public class Deck {
    private LinkedList<Card> deckList;
    private final int QUANTITY = 24;

    public Deck() {
        for(int i = 0; i < QUANTITY; i++) {
            deckList.add(new Card());
        }
    }

    public void printDeck() {
        for(int i = 0; i < QUANTITY; i++) {
            Card card = deckList.get(i);
            System.out.println(card.getName());
            System.out.println(card.getElement());
            System.out.println(card.getDefence());
            System.out.println(card.getAttack());
        }
    }
}
