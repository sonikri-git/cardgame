/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.Scanner;

/**
 *
 *  @author Kritish Soni/ Student ID: 991720996
 */
//factory class to hide creation of objects/ instances
public class GameFactory {
    private Player player1;
    private Player player2;
    private Deck deck;
    
    
     public GameFactory(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Deck();
        dealCards();
    }

    private void dealCards() {
        while (!deck.isEmpty()) {
            player1.getHand().addCard(deck.drawCard());
            player2.getHand().addCard(deck.drawCard());
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;

        while (rounds < 4 && !player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
            rounds++;
            System.out.println("Round " + rounds);
            playRound();

            if (rounds < 4) {
                System.out.println("Play another round? (yes/no)");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        determineWinner();
    }

    private void playRound() {
        Card card1 = player1.getHand().playCard();
        Card card2 = player2.getHand().playCard();

        System.out.println(player1.getUsername() + " plays " + card1);
        System.out.println(player2.getUsername() + " plays " + card2);

        if (card1.getValue().getValue() > card2.getValue().getValue()) {
            player1.getHand().addCard(card1);
            player1.getHand().addCard(card2);
            System.out.println(player1.getUsername() + " wins this round.");
        } else if (card2.getValue().getValue() > card1.getValue().getValue()) {
            player2.getHand().addCard(card1);
            player2.getHand().addCard(card2);
            System.out.println(player2.getUsername() + " wins this round.");
        } else {
            handleWar(card1, card2);
        }
    }

    private void handleWar(Card card1, Card card2) {
        System.out.println("War!");

        if (player1.getHand().size() < 4 || player2.getHand().size() < 4) {
            System.out.println("Not enough cards to continue war.");
            return;
        }

        Card[] warCards1 = new Card[4];
        Card[] warCards2 = new Card[4];

        warCards1[0] = card1;
        warCards2[0] = card2;

        for (int i = 1; i < 4; i++) {
            warCards1[i] = player1.getHand().playCard();
            warCards2[i] = player2.getHand().playCard();
        }

        System.out.println(player1.getUsername() + " plays " + warCards1[3]);
        System.out.println(player2.getUsername() + " plays " + warCards2[3]);

        if (warCards1[3].getValue().getValue() > warCards2[3].getValue().getValue()) {
            for (Card card : warCards1) {
                player1.getHand().addCard(card);
            }
            for (Card card : warCards2) {
                player1.getHand().addCard(card);
            }
            System.out.println(player1.getUsername() + " wins the war.");
        } else if (warCards2[3].getValue().getValue() > warCards1[3].getValue().getValue()) {
            for (Card card : warCards1) {
                player2.getHand().addCard(card);
            }
            for (Card card : warCards2) {
                player2.getHand().addCard(card);
            }
            System.out.println(player2.getUsername() + " wins the war.");
        } else {
            handleWar(warCards1[3], warCards2[3]);
        }
    }

    private void determineWinner() {
        int player1Cards = player1.getHand().size();
        int player2Cards = player2.getHand().size();

        System.out.println("Game Over!");
        System.out.println(player1.getUsername() + " has " + player1Cards + " cards.");
        System.out.println(player2.getUsername() + " has " + player2Cards + " cards.");

        if (player1Cards > player2Cards) {
            System.out.println(player1.getUsername() + " wins the game!");
        } else if (player2Cards > player1Cards) {
            System.out.println(player2.getUsername() + " wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}