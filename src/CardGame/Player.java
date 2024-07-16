package cardgame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 *  @author Kritish Soni/ Student ID: 991720996
 */
public class Player {
    private String username;
    private HandCard hand;

    public Player(String username) {
        this.username = username;
        this.hand = new HandCard();
    }

    public String getUsername() {
        return username;
    }

    public HandCard getHand() {
        return hand;
    }
}