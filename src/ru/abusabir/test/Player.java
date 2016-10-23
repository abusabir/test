package ru.abusabir.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Oleg
 * 23.10.2016
 */
public class Player {
    private String name;
    private int health = 50;
    private List<Card> handCards;
    private Deck deck;
    private List<Card> deskList;
    private final int FIRST_HAND = 4;

    public Player(String name, Deck deck) {
        this.name = name;
        this.handCards = new ArrayList<Card>();
        this.deck = deck;
        this.deskList = this.deck.getDeckList();
        this.takeCards(FIRST_HAND);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    private void removeCardFromHand(int index) {
        this.handCards.remove(index);
    }

    public void takeCards(int numberOfCards) {

        if(this.deskList.size() == 0) return;

        for(int i = 0; i < numberOfCards; i++) {
            this.handCards.add(this.deskList.get(this.deskList.size() - 1));
            this.deskList.remove(this.deskList.size() - 1);
            System.out.println("Player " + this.name + " take " + this.handCards.get(this.handCards.size() - 1));
        }

        System.out.println(this.deskList.size() + " in the desk");
    }

    public void attack(Player attacked) throws IOException {
        if(this.getHandCards().size() == 0) throw new GameOverException("Game over");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Your turn, " + this.getName());
        this.printCards();

        System.out.print(this.getName() + ", enter the number of your card for attack :");
        int indexOfCard = Integer.parseInt(reader.readLine()) - 1;
        Card cardForAttack = this.handCards.get(indexOfCard);
        this.removeCardFromHand(indexOfCard);
        System.out.println(this.getName() + " attack with " + cardForAttack);
        this.takeCards(1);
        attacked.defence(this, cardForAttack);

    }

    public void defence(Player attacking, Card cardOfAttack) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You can defence, " + this.getName());
        this.printCards();
        System.out.print(this.getName() + ", enter the number of your card for defence or 0 for pass :");
        int defenceAnswer = Integer.parseInt(reader.readLine());
        if(defenceAnswer == 0) {
            this.decreaseHealth(cardOfAttack.getAttack());
        } else {
            Card cardOfDefence = this.getHandCards().get(defenceAnswer - 1);
            this.removeCardFromHand(defenceAnswer - 1);
            if(cardOfDefence.getElement() != cardOfAttack.getElement()) {
                System.out.println("The element must be the same");
                this.defence(attacking, cardOfAttack);
            }

            this.decreaseHealth(cardOfAttack.getAttack() - cardOfDefence.getDefence());
            this.takeCards(1);
        }


        this.attack(attacking);



    }

    public void decreaseHealth(int value) {
        if(value > 0) this.setHealth(this.getHealth() - value);
        System.out.println(this.getName() + "'s health decrease by " + value + " and now it is " + this.getHealth());
        if(this.getHealth() <= 0) {
            throw new GameOverException("Game over");
        }

    }

    public void printCards() {
        System.out.println("Your cards, " + this.getName() + " :");
        for(int i = 0; i < this.getHandCards().size(); i++) {
            System.out.println((i + 1) + ": " + this.getHandCards().get(i));
        }
    }


}
