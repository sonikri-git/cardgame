/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *  @author Kritish Soni/ Student ID: 991720996
 */
public class Deck {
   private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(value, suit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public int size() {
        return cards.size();
    }
}

