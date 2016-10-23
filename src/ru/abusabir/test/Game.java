package ru.abusabir.test;

/**
 * Oleg
 * 23.10.2016
 */
public class Game {
    private Deck deck;
    private Player player1;
    private Player player2;
    private Player[] playersArr = new Player[2];

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
