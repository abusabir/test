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
        try {
            players[randomPlayerIndex].attack(players[1 - randomPlayerIndex]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(player1.getHealth() > player2.getHealth()) {
                System.out.println(player1.getName() + " win");
            } else {
                System.out.println(player2.getName() + " win");
            }

        }


    }

}
