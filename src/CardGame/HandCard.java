/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *   @author Kritish Soni/ Student ID: 991720996
 */
public class HandCard {
    private LinkedList<Card> hand;

    public HandCard() {
        hand = new LinkedList<>();
    }

    public void addCard(Card card) {
        hand.addLast(card);
    }

    public Card playCard() {
        return hand.removeFirst();
    }

    public int size() {
        return hand.size();
    }

    public boolean isEmpty() {
        return hand.isEmpty();
    }
}