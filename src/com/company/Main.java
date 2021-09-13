package com.company;

public class Main {


    public static void main(String[] args) {
        Cards cards = new Cards();
        System.out.println("Current card count "+  cards.getCurrentCardCount());
        cards.shuffle();
        cards.pickCard();
        cards.pickCard();
        cards.pickCard();
        cards.pickCard();
        cards.pickCard();
        System.out.println(cards);

//        for(int i = 0; i < 416; i++){
//        cards.pickCard();
//        }


        System.out.println("Current chute count "+  cards.getCurrentCardCount());

    }

}

