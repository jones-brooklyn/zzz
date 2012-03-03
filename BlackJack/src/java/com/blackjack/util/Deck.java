package com.blackjack.util;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    private List<Card> cards;


    public Deck()
    {
        cards = new ArrayList<Card>(52);
        createDeck();
    }


    private void createDeck()
    {
        for (Suit suit : Suit.values())
        {
            for (CardValue cardValue : CardValue.values())
            {
                cards.add(new Card(cardValue, suit));
            }
        }
    }


    public List<Card> getCards()
    {
        return cards;
    }
}
