package com.blackjack.util;

import java.util.LinkedList;
import java.util.List;

public class Shue
{
    private LinkedList<Card> cards;
    private final int        TOTAL_NUMBER_OF_CARDS;


    public Shue(int numberOfDecks)
    {
        this.cards = new LinkedList<Card>();
        for (int j = 0; j < numberOfDecks; j++)
        {
            Deck deck = new Deck();
            this.cards.addAll(deck.getCards());
        }

        TOTAL_NUMBER_OF_CARDS = cards.size();

        shuffle();
    }


    public void addCardsToShue(List<Card> cardsToAdd)
    {
        this.cards.addAll(cardsToAdd);
        shuffle();
    }


    public void shuffle()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < cards.size(); j++)
            {
                int newPosition = (int) (Math.random() * cards.size());
                Card card = cards.remove(newPosition);
                cards.add(card);
            }
        }
    }


    public int getNumberOfCards()
    {
        return cards.size();
    }


    public boolean isReshuffleNeeded()
    {
        return (cards.size() < (TOTAL_NUMBER_OF_CARDS * .30));
    }


    public void print()
    {
        for (Card card : cards)
        {
            System.out.println(card);
        }
    }


    public Card getNextCard()
    {
        return cards.removeFirst();
    }
}
