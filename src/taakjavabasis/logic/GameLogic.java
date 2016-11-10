package taakjavabasis.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {

    private Player player1;
    private Player player2;
    private Player[] players;

    public GameLogic() {
        this.players = new Player[2];
    }

    public void addPlayers(Scanner reader) {
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

            player1 = new Player(p1Name, false);
            player2 = new Player("CPU", true);
        } else if (playersInput == 2) {
            System.out.print("Enter the name of player 1: ");
            String p1Name = reader.nextLine();
            System.out.print("Enter the name of player 2: ");
            String p2Name = reader.nextLine();

            player1 = new Player(p1Name, false);
            player2 = new Player(p2Name, false);
        } else {
            player1 = new Player("CPU1", true);
            player2 = new Player("CPU2", true);
        }

        players[0] = player1;
        players[1] = player2;
    }

    public void addPlayers(Player p1, Player p2) {
        players[0] = p1;
        player1 = p1;
        players[1] = p2;
        player2 = p2;
    }

    public int compareTo(Card card1, Card card2) {
        if (card1.getValue() == card2.getValue()) {
            return 0;
        } else if (card1.getValue() > card2.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }

    public void game(Menus menu) {
        gameLoop:
        while (player2.handSize() > 0) {
            Card[] drawnCards = new Card[2];
            for (int i = 0; i < players.length; i++) {
                if (!players[i].getCPU()) {
                    Card card = menu.gameMenu(players[i]);
                    if (card.getSuit() == 99) {
                        players[i].setHasForfeited();
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

            roundWinner(drawnCards[0], drawnCards[1]);
        }

        gameWinner();
        menu.mainMenu();
    }

    public void gameWinner() {
        String winner = "";
        if (player1.getHasForfeited()) {
            winner = player2.getName();
        } else if (player2.getHasForfeited()) {
            winner = player1.getName();
        } else if (player1.wonHandSize() > player2.wonHandSize()) {
            winner = player1.getName();
        } else if (player1.wonHandSize() < player2.wonHandSize()) {
            winner = player2.getName();
        } else {
            winner = "It's a tie!";
        }
        System.out.println("\nThe winner is: " + winner + "!\n"
                + player1.getName() + ": " + player1.wonHandSize() + " cards.\n"
                + player2.getName() + ": " + player2.wonHandSize() + " cards.\n");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void preparation() {
        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleCards();
        for (int i = 0; i < deck.getCards().length; i++) {
            if (i % 2 == 0) {
                player1.addCard(deck.getCards()[i]);
            } else {
                player2.addCard(deck.getCards()[i]);
            }
        }
    }

    public void roundTie(Card[] cards) {
        Card p1 = player1.drawCard();
        Card p2 = player2.drawCard();

        Card[] temp = new Card[cards.length + 2];

        int i = 0;
        for (Card card : cards) {
            temp[i] = cards[i];
            i++;
        }

        temp[i] = p1;
        i++;
        temp[i] = p2;

        cards = temp;

        System.out.println(player1.getName() + ": " + p1.getCardInfo());
        System.out.println(player2.getName() + ": " + p2.getCardInfo());

        if (compareTo(p1, p2) == 1) {
            player1.wonRound(cards);
        } else if (compareTo(p1, p2) == -1) {
            player2.wonRound(cards);
        } else {
            System.out.println("It's another tie!");
            roundTie(cards);
        }
    }

    public void roundWinner(Card card1, Card card2) {
        Card[] wonCards = {card1, card2};

        if (compareTo(card1, card2) == 1) {
            player1.wonRound(wonCards);
        } else if (compareTo(card1, card2) == -1) {
            player2.wonRound(wonCards);
        } else {
            System.out.println("It's a tie!");
            roundTie(wonCards);
        }
    }
}
