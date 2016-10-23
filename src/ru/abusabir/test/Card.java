package ru.abusabir.test;

import java.util.Random;

/**
 * Oleg
 * 23.10.2016
 */
public class Card {
    private CardName name;
    private Element element;
    private int defence;
    private int attack;
    private final int MAX_POINTS = 10;

    public Card(CardName name, Element element, int defence, int attack) {
        this.name = name;
        this.element = element;
        this.defence = defence;
        this.attack = attack;
    }

    public Card() {
        Random random = new Random();
        this.name = CardName.values()[random.nextInt(CardName.values().length)];
        this.element = Element.values()[random.nextInt(Element.values().length)];
        this.defence = random.nextInt(MAX_POINTS + 1);
        this.attack = random.nextInt(MAX_POINTS + 1);
    }

    public CardName getName() {
        return name;
    }

    public Element getElement() {
        return element;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name=" + name +
                ", element=" + element +
                ", defence=" + defence +
                ", attack=" + attack +
                '}';
    }
}
