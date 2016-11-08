package taakjavabasis.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    /*
     Constructor for Deck
     Creates an empty List containing cards
     */
    public Deck() {
        this.cards = new ArrayList();
    }

    /*
    Returns the cards in the deck.
     */
    public List<Card> getCards() {
        return cards;
    }

    /*
    Creates a 52 card deck twice
     */
    public void populateDeck() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 13; k++) {
                    cards.add(new Card(j, k));
                }
            }
        }
    }

    /*
     Shuffles the cards.
     */
    public void shuffleCards() {
        Collections.shuffle(cards);
    }
}
