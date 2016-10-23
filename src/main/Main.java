package main;

import ru.abusabir.test.Deck;
import ru.abusabir.test.Player;

import java.io.IOException;
import java.util.Random;

/**
 * Oleg
 * 23.10.2016
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        Player player1 = new Player("Ivan", deck);
        Player player2 = new Player("Piter", deck);
        Player[] players = {player1, player2};
        int randomPlayerIndex = new Random().nextInt(2);
        players[randomPlayerIndex].attack(players[1 - randomPlayerIndex]);

    }

}
