/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gydo194
 */
public class Deck {

    ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        //buildNewCard();
        //hier een functie aanroepen die je cards in je deck gooit.
        //van ieder type ( harten azen etc) 13 kaarten maken
        
        /*
        for(Card.suit s : Card.suit.values() ) {
            
            System.out.println("looped suit");
            for(Card.label l : Card.label.values() ) {
                
                System.out.println("looped label");
                
                for(int i = 1; i < 14; i++) {
                    buildNewCardByOptions(s, l, i);
                }
                
                
            }
            
            
        }
        */
        
        for(Card.suit s : Card.suit.values() ) {
            System.out.println("Looped suit");
            for(int i = 1; i < 14; i++) {
                //loop 13 times for every card suit
                buildNewCardByOptions(s,i);
            }
        }
        
        
        
        
        Collections.shuffle(cards);

    }
    
    private void buildNewCardByOptions(Card.suit suit, int num) {
        
        
        
        Card.label label = Card.label.NONE;
        
        switch(num) {
            
            
            case 10:
                label = Card.label.ASE;
                System.out.println("Setting new card label = ASE");
                break;
            case 11:
                label = Card.label.JOKER;
                System.out.println("Setting new card label = JOKER");
                break;
                
            case 12:
                label = Card.label.QUEEN;
                System.out.println("Setting new card label = QUEEN");
                break;   
                
            case 13:
                label = Card.label.KING;
                System.out.println("Setting new card label = KING");
                break;
              
            default:
                System.out.println("Setting new card label = NONE (default case)");
                break;
                
           
               
        }
        
        
        cards.add(new Card(num,suit,label));
    }
    
    
    public int getCardsRemaining() {
        return cards.size();
    }
    

    public void buildNewCard(Card.suit suit, Card.label label) {
        Card c = CardFactory.getRandomCardInstanceWithProperties(suit,label);
        cards.add(c);
    }

    public Card getNextCard() {
        Card c = cards.get(0);
        cards.remove(c);
        //buildNewCard(); //make a new card so the deck doesn't run out
        return c;
    }

}
