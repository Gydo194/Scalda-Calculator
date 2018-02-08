/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gydo194
 */
public class Cardgame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int userScore = 0;
        boolean debug = false;
        //CardFactory cf = new CardFactory();
        Card currentCard = null;
        Card nextCard = null;
        char userGuess = '\0';
        Deck deck = new Deck();
        currentCard = deck.getNextCard();

        System.out.printf("Initialization completed, starting game.\nCurrent card count: '%d'.\n",deck.getCardsRemaining());
        
        while (true) {
            //currentCard = deck.getNextCard();
            //nextCard = deck.getNextCard();
            
            do { //may result in lower final card count
                nextCard = deck.getNextCard();
            } while ( currentCard.getNumber() == nextCard.getNumber() );
             
            if(deck.getCardsRemaining() < 1) {
                System.out.printf("\r\n\r\n\r\nGame Over, Your final score is: %d\r\n\r\n\r\n",userScore);
                System.exit(0);
            }
            
            
            if (debug) {
                System.out.printf("Current card value is '%d', Next card value is '%d'. Next suit is '%s'. Next label is '%s'.\n", currentCard.getNumber(), nextCard.getNumber(), nextCard.getSuit().name(), nextCard.getLabel().name());
            }

            System.out.printf("Amount of cards remaining: '%d'.\nCurrent card value: '%d'. Suit: '%s'. Label: '%s'.\nIs the next card higher or lower?\nEnter 'h' or 'l'.\n", deck.getCardsRemaining(), currentCard.getNumber(), currentCard.getSuit().name(), currentCard.getLabel().name());

            userGuess = input.next().charAt(0);

            System.out.printf("User guessed '%c'.\n", userGuess);

            if (userGuess == 'l') {

                if (currentCard.getNumber() > nextCard.getNumber()) {
                    userScore++;
                    System.out.printf("You guessed correctly!!\nYour score is now: '%d'.\n", userScore);
                    currentCard = nextCard;

                } else {

                    System.err.printf("That was not correct.\nYour score is: '%d'.\n", userScore);
                    if (!debug) {
                        System.exit(0);
                    } else {
                        System.err.println("Not exiting because of debug/cheat mode");
                    }

                }

            } else if (userGuess == 'h') {

                if (currentCard.getNumber() < nextCard.getNumber()) {
                    userScore++;
                    System.out.printf("You guessed correctly!!\nYour score is now: '%d'.\n", userScore);
                    currentCard = nextCard;

                } else {

                    System.err.printf("That was not correct.\nYour score is: '%d'.\n", userScore);
                    if (!debug) {
                        System.exit(0);
                    } else {
                        System.err.println("Not exiting because of debug/cheat mode");
                    }

                }

            } else if (userGuess == 'd') {
                System.err.println("TOGGLING CHEAT/DEBUG MODE");
                debug = !debug;
            } else if (userGuess == 's') {
                System.err.println("Skipping 10 cards...");
                for (int i = 0; i < 9; i++) {
                    nextCard = deck.getNextCard();
                }
            }
        }
    }

}
