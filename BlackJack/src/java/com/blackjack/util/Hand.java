package com.blackjack.util;

import java.util.ArrayList;
import java.util.List;

public class Hand
{
    private List<Card> cards;


    public Hand()
    {
        cards = new ArrayList<Card>();
    }


    public void addCard(Card card)
    {
        cards.add(card);
    }


    public int getNumberOfCards()
    {
        return cards.size();
    }


    public List<Card> seeCards()
    {
        return cards;
    }


    List<Card> clearHand()
    {
        List<Card> cardsToClear = cards;
        cards = new ArrayList<Card>();

        return cardsToClear;
    }


    public int getValue()
    {
        int value = 0;
        int numberOfAces = 0;
        for (Card card : cards)
        {
            value += card.getValue();
            numberOfAces += card.isAce() ? 1 : 0;
        }

        if (numberOfAces == 0)
        {
            return value;
        }

        while (numberOfAces > 0 && (value + 10) <= 21)
        {
            value += 10;
            numberOfAces--;
        }

        return value;
    }


    public boolean isBlackJack()
    {
        if (this.getNumberOfCards() != 2)
        {
            return false;
        }

        return isAceAndFaceCard(this.seeCards().get(0), this.seeCards().get(1));
    }


    private boolean isAceAndFaceCard(Card cardOne,
                                     Card cardTwo)
    {
        return cardOne.isAce() && cardTwo.isFaceCard() || cardOne.isFaceCard() && cardTwo.isAce();
    }


    public boolean isSixteenOrUnder()
    {
        return this.getValue() <= 16;
    }


    public boolean isSoftSevenTeen()
    {
        if (this.getNumberOfCards() != 2)
        {
            return false;
        }

        return isAceAndSix(this.seeCards().get(0), this.seeCards().get(1));
    }


    private boolean isAceAndSix(Card cardOne,
                                Card cardTwo)
    {
        return cardOne.isAce() && cardTwo.getCardValue().equals(CardValue.SIX)
               || cardOne.getCardValue().equals(CardValue.SIX)
               && cardTwo.isAce();
    }


    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (Card card : cards)
        {
            sb.append(card);
            sb.append("\n");
        }

        return sb.toString();
    }


    public boolean isBust()
    {
        return this.getValue() > 21;
    }
}
