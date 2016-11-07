package taakjavabasis;

import java.util.Scanner;
import taakjavabasis.logic.Card;
import taakjavabasis.logic.Deck;
import taakjavabasis.logic.GameMechanics;
import taakjavabasis.logic.Player;
import taakjavabasis.ui.UI;

public class TaakJavaBasis {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        
        UI ui = new UI(reader);
        ui.run();
        
        /*Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        
        deck1.populateDeck();
        deck2.populateDeck();
        
        Player player1 = new Player("herp");
        Player player2 = new Player("derp");
        
        player1.setHand(deck1.getCards());
        player2.setHand(deck2.getCards());
        
        player1.shuffleHand();
        player2.shuffleHand();
        
        GameMechanics game = new GameMechanics(player1, player2);
        
        while(player1.handSize() > 0 || player2.handSize() > 0) {
            Card p1 = player1.drawCard();
            Card p2 = player2.drawCard();

            System.out.println(p1.getCardInfo());
            System.out.println(p2.getCardInfo());

            int result = game.compareCards(p1, p2);
            System.out.println("result: " + result);
            if (result == 1) {
                player1.wonRound();
            } else if (result == -1) {
                player2.wonRound();
            }

            System.out.println(player1.getScore());
            System.out.println(player2.getScore());
            
            Thread.sleep(500);
        }*/
    }
    
}
