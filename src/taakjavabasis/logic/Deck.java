package taakjavabasis.logic;

import java.util.Random;

/**
 *
 * @author Michiel Thomassen
 */
public class Deck {

    private Card[] cards;

    /**
     * Deck creator
     */
    public Deck() {
        this.cards = new Card[104];
    }

    /**
     * returns all cards currently in this object
     *
     * @return the array of cards that this object holds
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Makes sure that each and every possible card gets added to the deck
     * Considering the requirements require 2 decks, this is done twice (the i
     * var in the first for-loop) The l-var makes sure that each cell will be
     * used once.
     */
    public void populateDeck() {
        for (int i = 0, l = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 13; k++) {
                    cards[l] = new Card(j, k);
                    l++;
                }
            }
        }

    }

    /**
     * debugging use
     */
    public void printCards() {
        for (Card card : cards) {
            System.out.println(card.getCardInfo());
        }
    }

    /**
     * Shuffles cards. SOURCE:
     * http://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
     */
    // I think I understand this..
    public void shuffleCards() {
        Random rgen = new Random();  // Random number generator

        for (int i = 0; i < cards.length; i++) {
            int randomPosition = rgen.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }
    }
}
