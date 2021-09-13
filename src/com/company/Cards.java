package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final int numberOfCardsInDeck = 52;
    private int newCards;
    private final int numberOfDecks = 8;
    private final int numberOfSuits = 4;
    private final int numberOfCardsPerSuit = 13;
    private int card;
    private int arrayNumberCounter = 0;
    private int playersTotal;
    private int currentCardCount;

    public static List<Integer> unshuffledDeck = new ArrayList<>();
    public static List<Integer> shuffledDeck = new ArrayList<>();
    public static List<Integer> playersHand = new ArrayList<>();

    public Cards() {
        for (int i = 1; i <= numberOfDecks; i++) {
            createAnotherDeck();
            currentCardCount = numberOfCardsInDeck * i;
        }
        System.out.println("There are " + numberOfDecks + " decks of cards.");
    }

    public int getCurrentCardCount() {
        return currentCardCount;
    }

    public void shuffle() {
        for (int theCard : unshuffledDeck) {
            int result = (int) (Math.random() * unshuffledDeck.size());
            theCard = unshuffledDeck.get(result);
            shuffledDeck.add(theCard);
        }
        System.out.println("The cards are shuffled and placed in chute. \n");
    }

    public void createAnotherDeck() {
        for (int i = 1; i <= numberOfSuits; i++) {
            for (int j = 2; j < numberOfCardsPerSuit + 2; j++) {
                newCards = (i * 100) + j;
                unshuffledDeck.add(newCards);
            }
        }
    }

    @Override
    public String toString() {
        return ("Un-shuffled Deck: " + unshuffledDeck + "\n" + "Players cards: " + playersHand + "\n" + "Shuffled " +
                "Deck: " + shuffledDeck);
    }

    public void pickCard() {
        System.out.println("Player draws a card.");
        int theCard;
        theCard = shuffledDeck.get(0);
        convertToCard(theCard);
        playersHand.add(theCard);
        shuffledDeck.remove(0);
        currentCardCount--;
    }

    public void convertToCard(int theCard) { // 100s hearts, 200s diamonds, 300s spades, 400s clubs
        if (theCard < 115) {
            card = theCard - 100;
            String suit = "hearts";
            if (card >= 11) {
                checkForFaceCards(card, suit);
                return;
            }
            System.out.println(card + " of hearts.\n");
        }
        if (theCard > 201 && theCard < 215) {
            card = theCard - 200;
            String suit = "diamonds";
            if (card >= 11) {
                checkForFaceCards(card, suit);
                return;
            }
            System.out.println(card + " of diamonds.\n");
        }
        if (theCard > 301 && theCard < 315) {
            card = theCard - 300;
            String suit = "spades";
            if (card >= 11) {
                checkForFaceCards(card, suit);
                return;
            }
            System.out.println(card + " of spades.\n");
        }
        if (theCard > 401 && theCard < 415) {
            card = theCard - 400;
            String suit = "clubs";
            if (card >= 11) {
                checkForFaceCards(card, suit);
                return;
            }
            System.out.println(card + " of clubs.\n");
        }
    }

    public void checkForFaceCards(int card, String suit) {
        switch (card) {
            case 11 -> {
                System.out.println("Ace of " + suit + ". \n");
            }
            case 12 -> {
                System.out.println("Jack of " + suit + ". \n");
            }
            case 13 -> {
                System.out.println("Queen of " + suit + ". \n");
            }
            case 14 -> {
                System.out.println("King of " + suit + ". \n");
            }
        }
    }
}
