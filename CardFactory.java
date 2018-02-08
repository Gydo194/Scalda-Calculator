/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Random;
/**
 *
 * @author gydo194
 */
public class CardFactory {
    
   // Random r;
    
    public CardFactory() {
       // this.r = new Random();
    }
    /*
    public static Card getInstance(int num) {
        return new Card(num);
    }
    */
    
    
    /*
    public static Card getRandomCardInstance() {
        int rnd;// = (new Double(Math.random()*10)).intValue();
        //rnd = (new Double(Math.ceil( Math.random() * 10 ))).intValue();
        //rnd = (new Double(Math.random()*10)).intValue();
        do {
            rnd = (new Random()).nextInt();
        } while(rnd == 0); //ensure rnd cannot be 0
        
        //System.out.printf("CardFactory::getRandomCardInstance(): Random int is '%d'.\n",rnd);
        return new Card(rnd);
    }
    */
    
    public static Card getRandomCardInstanceWithProperties(Card.suit suit,Card.label label) {
        int rnd;// = (new Double(Math.random()*10)).intValue();
        //rnd = (new Double(Math.ceil( Math.random() * 10 ))).intValue();
        //rnd = (new Double(Math.random()*10)).intValue();
        do {
            rnd = (new Random()).nextInt();
        } while(rnd == 0); //ensure rnd cannot be 0
        
        //System.out.printf("CardFactory::getRandomCardInstance(): Random int is '%d'.\n",rnd);
        return new Card(rnd,suit,label);
    }
    
    
    
}
