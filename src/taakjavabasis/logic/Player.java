package taakjavabasis.logic;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int score;
    private boolean cpu;
    private boolean hasForfeited;
    private List<Card> playHand;

    /*
     Creates player, creates empty hand, defaults score to 0, names player.
     */
    public Player(String name, boolean cpu) {
        this.name = name;
        this.playHand = new ArrayList();
        this.score = 0;
        this.cpu = cpu;
    }

    /*
     returns the name
     */
    public String getName() {
        return name;
    }

    /*
     Returns score.
     */
    public int getScore() {
        return score;
    }

    /*
     returns whether the player is a real player or AI
     */
    public boolean getCPU() {
        return cpu;
    }

    /*
     Getter to see if a player forfeited. Required for declaring winner.
     */
    public boolean getHasForfeited() {
        return hasForfeited;
    }

    /*
     Sets hasForfeited to true if player forfeits
     */
    public void setHasForfeited() {
        hasForfeited = true;
    }

    /*
     add a card to the playing hand
     */
    public void addCard(Card card) {
        playHand.add(card);
    }

    /*
     Draws a card and removes it from the player's hand.
     */
    public Card drawCard() {
        Card card = playHand.get(playHand.size() - 1);
        playHand.remove(playHand.size() - 1);
        return card;
    }

    /*
     Increases the player's score if he won the round.
     */
    public void wonRound() {
        score++;
        System.out.println(name + " wins this round!");
    }

    /*
     Debugging/testing use.
     */
    public int handSize() {
        return playHand.size();
    }

    /*
     Debugging/testing use.
     */
    public void printHand() {
        for (Card card : playHand) {
            System.out.println(card.getCardInfo());
        }
    }
}
