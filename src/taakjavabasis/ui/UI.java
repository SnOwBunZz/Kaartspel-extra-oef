
package taakjavabasis.ui;

import java.util.Scanner;
import taakjavabasis.logic.Card;
import taakjavabasis.logic.Deck;
import taakjavabasis.logic.Player;


public class UI {
    private Scanner reader;
    private Player[] players;
    
    public UI(Scanner reader) {
        this.reader = reader;
        this.players = new Player[2];
    }
    
    public void run(){
        mainMenu();
    }
    
    private void players() {
        int playersInput = 0;
        while(true) {
            try {            
                System.out.print("How many players? (0 - 2) ");
                playersInput = Integer.parseInt(reader.nextLine());
                if (playersInput >= 0 && playersInput <= 2) {
                    break;
                }
            } catch (NumberFormatException nFE) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        if (playersInput == 1) {
            System.out.print("Enter the name of player 1: ");
            String p1Name = reader.nextLine();
            
            players[0] = new Player(p1Name, false);
            players[1] = new Player("CPU", true);
        } else if (playersInput == 2) {
            System.out.print("Enter the name of player 1: ");
            String p1Name = reader.nextLine();
            System.out.print("Enter the name of player 2: ");
            String p2Name = reader.nextLine();
            
            players[0] = new Player(p1Name, false);
            players[1] = new Player(p2Name, false);
        } else {
            players[0] = new Player("CPU1", true);
            players[1] = new Player("CPU2", true);
        }
    }
    
    private void preparation() {
        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleCards();
        for (int i = 0; i < deck.getCards().size(); i++) {
            if (i % 2 == 0) {
                players[0].addCard(deck.getCards().get(i));
            } else {
                players[1].addCard(deck.getCards().get(i));
            }
        }
    }
    
    private void game(){
        gameLoop:
        while(players[1].handSize() > 0) {
            Card[] drawnCards = new Card[2];
            for (int i = 0; i < players.length; i++) {
                if (!players[i].getCPU()) {
                    Card card = gameMenu(players[i]);
                    if (card.getSuit() == 99) {
                        break gameLoop;
                    } else {
                        drawnCards[i] = card;
                    }
                } else if (players[i].getCPU()){
                    drawnCards[i] = drawCard(players[i]);
                }
            }

            for(int i = 0; i < drawnCards.length; i++) {
                System.out.println(players[i].getName() + ": " + drawnCards[i].getCardInfo());
            }

            int compareResult = drawnCards[0].compareTo(drawnCards[1]);
            if (compareResult == 1) {
                players[0].wonRound();
            } else if (compareResult == -1) {
                players[1].wonRound();
            } else {
                System.out.println("Tie!");
            }
            System.out.println("");
        }
        
        
        // TODO: clean this god damned mess up
        String winner = "";
        if (players[0].getHasForfeited()) {
            winner = players[1].getName();
        } else if (players[1].getHasForfeited()) {
            winner = players[0].getName();
        } else if (players[0].getScore() > players[1].getScore()) {
            winner = players[0].getName();
        } else if (players[0].getScore() < players[1].getScore()) {
            winner = players[1].getName();
        } else {
            winner = "It's a tie!";
        }
        System.out.println("The winner is: " + winner + "!\n"
                + players[0].getName() + ": " + players[0].getScore() + " points.\n"
                + players[1].getName() + ": " + players[1].getScore() + " points.");
        
    }
    
    private void mainMenu() {
        System.out.println("MAIN MENU"
                + "\n--------"
                + "\n[1] Shuffle"
                + "\n[2] Quit game");
        
        /*
        Asks for input, only one or two accepted
        Keep in mind that when you add menu options to adjust this!
        */
        int input = 0;
        while(true) {
            try {
                input = Integer.parseInt(reader.nextLine());
                if (input < 1 || input > 2) {
                    System.out.println("Please enter 1 or 2.");
                } else {
                    break;
                }
            } catch (NumberFormatException nFE) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        switch(input) {
            case 1 :    players();
                        preparation();
                        game();
            case 2: break;
        }
    }
    
    private Card drawCard(Player player) {
        return player.drawCard();
    }
    
    private Card gameMenu(Player player) {
        System.out.print("[1] Draw card [2] Forfeit"
                + "\nPlayer " + player.getName() + ": ");
        int input = Integer.parseInt(reader.nextLine());
        System.out.println("");
        
        Card card = new Card(99,99);
        
        switch(input) {
            case 1 : card = drawCard(player); return card;
            case 2 : return card;
        }
        
        return card;
    }
}
