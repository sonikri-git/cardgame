/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CardGame;

/**
 *
 * @author sonikri
 */
public class Player {
  private final String name;
    private final HandCard hand;

    public Player(String name) {
        this.name = name;
        this.hand = new HandCard();
    }

    public String getName() {
        return name;
    }

    public HandCard getHand() {
        return hand;
    }

    //add cards to hand
    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public Card playCard() {
        return hand.playCard();
    }

    //returns number of cards in hand
    public int getHandSize() {
        return hand.size();
    }

    //tells whether hand is empty or not
    public boolean hasCards() {
        return !hand.isEmpty();
    }
}
   

