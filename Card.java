/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author gydo194
 */
public class Card {
    
    //suit hearts/diamonds/spades/clubs
    //label / 2 of 3 of J of k of q of A
   public enum suit {
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    };
    
    public  enum label { NONE, JOKER, KING, QUEEN, ASE };
    
    private int number;
    private suit suit;
    private label label;
    
    public Card(int number, suit suit, label label ) {
        this.number = number;
        this.suit = suit;
        this.label = label;
    }
    
    public int  getNumber() { return this.number; }
    public suit getSuit() { return this.suit; }
    public label getLabel() { return this.label; }
    
   // public void setNumber(int num) { this.number = num; }
}
