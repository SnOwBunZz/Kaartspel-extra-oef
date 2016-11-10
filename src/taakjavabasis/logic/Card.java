package taakjavabasis.logic;

public class Card implements Comparable<Card> {

    private static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int suit;
    private int value;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

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

    public String getCardInfo() {
        return VALUES[value] + " of " + SUITS[suit];
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}
