package taakjavabasis.logic;

import java.util.Arrays;

/**
 *
 * @author Michiel Thomassen
 */
public class Player {

    private boolean cpu;
    private boolean hasForfeited;
    private String name;
    private Card[] playHand;
    private Card[] wonHand;

    /**
     * Player constructor
     *
     * @param name sets the name of the player
     * @param cpu sets if the player is a cpu or a real player
     */
    public Player(String name, boolean cpu) {
        this.name = name;
        this.playHand = new Card[0];
        this.wonHand = new Card[0];
        this.cpu = cpu;
    }

    /**
     * adds a card to the playing hand
     *
     * @param card card to be added
     */
    public void addCard(Card card) {
        Card[] temp = new Card[playHand.length + 1];

        for (int i = 0; i < playHand.length; i++) {
            temp[i] = playHand[i];
        }

        temp[temp.length - 1] = card;
        playHand = temp;
    }

    /**
     * draws a card from the playing hand removes it from the playing hand
     * before returning it
     *
     * @return the card object that has been drawn
     */
    public Card drawCard() {
        Card card = playHand[playHand.length - 1];
        playHand = Arrays.copyOf(playHand, playHand.length - 1);
        return card;
    }

    /**
     * returns whether the player is a cpu or real player
     *
     * @return boolean true if cpu, false if real player
     */
    public boolean getCPU() {
        return cpu;
    }

    /**
     * returns whether the player has forfeited required for knowing and
     * determining the winner if one player has forfeited cpu doesn't forfeit.
     *
     * @return true if player has forfeited, false if the player has not
     * forfeited
     */
    public boolean getHasForfeited() {
        return hasForfeited;
    }

    /**
     * returns the name of the player
     *
     * @return String name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * returns the amount of cards in a player's hand
     *
     * @return int value of amount of cards in player's hand
     */
    public int handSize() {
        return playHand.length;
    }

    /**
     * Debugging use. Prints all cards in the player's hand.
     */
    public void printHand() {
        int i = 0;
        for (Card card : playHand) {
            System.out.println(i + ": " + card.getCardInfo());
            i++;
        }
    }

    /**
     * Setter for hasForfeited Required for the forfeit option in Menus.java
     */
    public void setHasForfeited() {
        hasForfeited = true;
    }

    /**
     * adds a single card to the won hand array.
     *
     * @param card card that has been won
     */
    public void wonCard(Card card) {
        Card[] temp = new Card[wonHand.length + 1];

        for (int i = 0; i < wonHand.length; i++) {
            temp[i] = wonHand[i];
        }

        temp[temp.length - 1] = card;
        wonHand = temp;
    }

    /**
     * the amount of cards in the winning hand
     *
     * @return int value of amount of won cards
     */
    public int wonHandSize() {
        return wonHand.length;
    }

    /**
     * passes the array of cards towards wonCard one by one and prints out the
     * winner of said round
     *
     * @param wonCards the array of cards that has been won
     */
    public void wonRound(Card[] wonCards) {
        for (Card card : wonCards) {
            wonCard(card);
        }

        System.out.println(name + " wins this round!");
    }
}
