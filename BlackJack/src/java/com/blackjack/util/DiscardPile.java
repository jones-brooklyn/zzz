package com.blackjack.util;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile
{
    private List<Card> cards;


    public DiscardPile()
    {
        this.cards = new ArrayList<Card>();
    }


    public void addHand(Hand hand)
    {
        cards.addAll(hand.clearHand());
    }


    public List<Card> clearDiscardPile()
    {
        List<Card> cardsToReturn = cards;
        cards = new ArrayList<Card>();

        return cardsToReturn;
    }
}
