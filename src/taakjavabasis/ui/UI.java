package taakjavabasis.ui;

import java.util.Scanner;
import taakjavabasis.logic.Card;
import taakjavabasis.logic.Deck;
import taakjavabasis.logic.GameLogic;
import taakjavabasis.logic.Player;

public class UI {

    private Scanner reader;
    private Player[] players;
    private GameLogic logic;

    public UI(Scanner reader) {
        this.reader = reader;
        this.players = new Player[2];
    }

    public void run() throws InterruptedException {
        mainMenu();
    }

    private void players() {
        int playersInput = 0;
        while (true) {
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

        System.out.println();
        this.logic = new GameLogic(players[0], players[1]);
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

    private void game() throws InterruptedException {
        gameLoop:
        while (players[1].handSize() > 0) {
            Card[] drawnCards = new Card[2];
            for (int i = 0; i < players.length; i++) {
                if (!players[i].getCPU()) {
                    Card card = gameMenu(players[i]);
                    if (card.getSuit() == 99) {
                        break gameLoop;
                    } else {
                        drawnCards[i] = card;
                    }
                } else if (players[i].getCPU()) {
                    drawnCards[i] = players[i].drawCard();
                }
            }

            System.out.println();
            for (int i = 0; i < drawnCards.length; i++) {
                System.out.println(players[i].getName() + ": " + drawnCards[i].getCardInfo());
            }

            logic.roundWinner(drawnCards[0], drawnCards[1]);
            System.out.println();
            Thread.sleep(100);
        }

        logic.gameWinner();

    }

    private void mainMenu() throws InterruptedException {
        System.out.println("MAIN MENU"
                + "\n--------"
                + "\n[1] Shuffle"
                + "\n[2] Quit game");

        /*
         Asks for input, only one or two accepted
         Keep in mind that when you add menu options to adjust this!
         */
        int input = 0;
        while (true) {
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

        switch (input) {
            case 1:
                players();
                preparation();
                game();
            case 2:
                break;
        }
    }

    private Card gameMenu(Player player) {
        System.out.print("[1] Draw card [2] Forfeit"
                + "\nPlayer " + player.getName() + ": ");
        int input = Integer.parseInt(reader.nextLine());

        Card card = new Card(99, 99);

        switch (input) {
            case 1:
                card = player.drawCard();
                return card;
            case 2:
                return card;
        }

        return card;
    }
}
