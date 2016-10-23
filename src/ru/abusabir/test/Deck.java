package ru.abusabir.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Oleg
 * 23.10.2016
 */
public class Deck {
    private List<Card> deckList;
    private final int QUANTITY = 24;

    public Deck() {
        this.deckList = new ArrayList<Card>();
        for (int i = 0; i < QUANTITY; i++) {
            this.deckList.add(new Card());
        }
    }

    public List<Card> getDeckList() {
        return deckList;
    }

    public void printDeck() {
        for (int i = 0; i < QUANTITY; i++) {
            Card card = this.deckList.get(i);
            System.out.println(card);
        }
    }
}
