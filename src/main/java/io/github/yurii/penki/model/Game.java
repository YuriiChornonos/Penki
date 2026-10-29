package io.github.yurii.penki.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  private Deck deck;
  private ArrayList<Player> players;
  private int currentPlayer;

  Scanner in = new Scanner(System.in);

  public Game() {
    deck = new Deck();
    players = new ArrayList<>();
  }

  // Main game loop
  public void startGame() {
    setup();
    while (!deck.isEmpty()) {
      takeTurnPhase1();
    }
    printHands();
  }

  // Initialising players and shuffling the deck
  public void setup() {
    while (players.size() < 4) {
      String name = in.nextLine();
      addPlayer(name);
    }

    deck.shuffle();

    drawInitialCards();
  }

  //
  public void takeTurnPhase1() {
    // Player is the current player taking turn. It's reference changes to the next
    // player each 'while' run
    Player player = players.get(currentPlayer);
    Card card;

    // Player draws a card
    System.out.println("\n" + player.getName() + "'s turn.");
    System.out.println("1. Draw a card");

    String choice = in.nextLine();
    if (choice.equals("1")) {
      card = player.drawCard(deck);
      System.out.println("Drew: " + card);
    }
    System.out.println();

    // Ask player who to give the card
    System.out.println("Choose who to give the card:");
    for (int i = 0; i < players.size(); i++) {
      System.out.println((i + 1) + ". " + players.get((currentPlayer + i) % players.size()).getName());
    }

    // Take the card from the current player and add it to the hand of the target
    // player
    choice = in.nextLine();

    int choiceIndex = Integer.parseInt(choice) - 1;
    Card cardToTransfer = player.getHand().remove(player.getHand().size() - 1);
    int targetPlayer = (currentPlayer + choiceIndex) % players.size();
    players.get(targetPlayer).getHand().add(cardToTransfer);

    // Pass the turn to the next player
    currentPlayer = (currentPlayer + 1) % players.size();

    // Print the number of cards left in deck
    System.out.println("Cards left: " + deck.getDeck().size());
    System.out.println();
    System.out.println("--------------------");
    System.out.println("--------------------");
    System.out.println();
  }

  public void takeTurnPhase2() {

  }

  public void endGame() {

  }

  public void addPlayer(String name) {
    players.add(new Player(name));
  }

  public void printHands() {
    // Print each player's hand
    for (Player player : players) {
      System.out.println(player.getName() + ":");
      for (int i = 0; i < player.getPenki().size(); i++) {
        System.out.print("|?|" + " ");
      }
      for (int i = 0; i < player.getHand().size(); i++) {
        System.out.print(player.getHand().get(i) + " ");
      }
      System.out.println();
      System.out.println();
    }
  }

  public void drawInitialCards() {
    for (Player player : players) {
      player.drawPenki(deck);
      player.drawPenki(deck);
      player.drawCard(deck);
    }
  }
}
