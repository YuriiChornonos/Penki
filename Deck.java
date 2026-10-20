import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck; 
    private int[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private String[] suits = {"\u2666", "\u2663", "\u2665", "\u2660"};

    public Deck () {
        deck = new ArrayList<>();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck.add(new Card(suits[i], ranks[j]));
            }
        }  
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        java.util.Collections.shuffle(deck);
    }

    public boolean isEmpty() {
        return deck.size() <= 0;
    }
}
