package com.blackjack.util;

public class Card
{
    private final CardValue cardValue;
    private final Suit      suit;


    public Card(CardValue cardValue,
                Suit suit)
    {
        this.cardValue = cardValue;
        this.suit = suit;
    }


    public CardValue getCardValue()
    {
        return cardValue;
    }


    public boolean isAce()
    {
        return getCardValue().equals(CardValue.ACE);
    }


    public int getValue()
    {
        return getCardValue().getValue();
    }


    public boolean isFaceCard()
    {
        return getCardValue().equals(CardValue.TEN) || getCardValue().equals(CardValue.JACK)
               || getCardValue().equals(CardValue.QUEEN)
               || getCardValue().equals(CardValue.KING);
    }


    public String toString()
    {
        return cardValue + " " + suit;
    }
}
