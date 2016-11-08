package taakjavabasis.logic;

public class Card implements Comparable<Card> {

    private static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int suit;
    private int value;

    /*
     Creates a card
     @param suit suit of the card
     @param value    value of the card
     */
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /*
    compares cards
     */
    @Override
    public int compareTo(Card card) {
        if (this.getValue() == card.getValue()) {
            return 0;
        } else if (this.getValue() > card.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }

    /*
    returns card suit and value in a readable manner
     */
    public String getCardInfo() {
        return VALUES[value] + " of " + SUITS[suit];
    }

    /*
    suit getter
     */
    public int getSuit() {
        return suit;
    }

    /*
    value getter
     */
    public int getValue() {
        return value;
    }

}
