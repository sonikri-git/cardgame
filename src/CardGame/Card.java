/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 *  @author Kritish Soni/ Student ID: 991720996
 */
public class Card {
      private CardValue value;
    private Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }
    
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
