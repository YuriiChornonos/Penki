package io.github.yurii.penki.model;

import java.util.ArrayList;

public class Player {
  private ArrayList<Card> hand;
  private ArrayList<Card> penki;
  private String name;

  public Player(String name) {
    hand = new ArrayList<>();
    penki = new ArrayList<>();
    this.name = name;
  }

  // Removes the topmost card from the deck, adds it to hand and prints the card
  public Card drawCard(Deck deck) {
    Card card = deck.getDeck().remove(deck.getDeck().size() - 1);
    hand.add(card);
    return card;
  }

  public void drawPenki(Deck deck) {
    Card card = deck.getDeck().remove(deck.getDeck().size() - 1);
    penki.add(card);
  }

  // Returns the list of a player's cards
  public ArrayList<Card> getHand() {
    return hand;
  }

  public ArrayList<Card> getPenki() {
    return penki;
  }

  // Return's a player's name
  public String getName() {
    return name;
  }
}
