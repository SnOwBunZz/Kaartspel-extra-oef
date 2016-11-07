
package taakjavabasis.logic;


public class GameMechanics {
    private Player player1;
    private Player player2;
    
    public GameMechanics(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public int compareCards(Card card1, Card card2) {
        if (card1.getValue() > card2.getValue()) {
            return 1;
        } else if (card1.getValue() < card2.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
