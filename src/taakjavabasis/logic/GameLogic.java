
package taakjavabasis.logic;


public class GameLogic {
    private Player player1;
    private Player player2;
    
    public GameLogic(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void gameWinner() {
        String winner = "";
        if (player1.getHasForfeited()) {
            winner = player2.getName();
        } else if (player2.getHasForfeited()) {
            winner = player1.getName();
        } else if (player1.getScore() > player2.getScore()) {
            winner = player1.getName();
        } else if (player1.getScore() < player2.getScore()) {
            winner = player2.getName();
        } else {
            winner = "It's a tie!";
        }
        System.out.println("The winner is: " + winner + "!\n"
                + player1.getName() + ": " + player1.getScore() + " points.\n"
                + player2.getName() + ": " + player2.getScore() + " points.");
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
    
    public void roundWinner(Card card1, Card card2) {
        if (compareTo(card1, card2) == 1) {
            System.out.println(player1.getName() + " is this round's winner!");
            player1.wonRound();
        } else if (compareTo(card1, card2) == -1) {
            System.out.println(player2.getName() + " is this round's winner!");
            player2.wonRound();
        } else {
            System.out.println("It's a tie!");
        }
    }
}
