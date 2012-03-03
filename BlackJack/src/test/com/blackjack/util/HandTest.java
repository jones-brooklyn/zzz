package com.blackjack.util;

import junit.framework.Assert;

import org.junit.Test;

public class HandTest
{

    @Test
    public void testCardValue()
    {
        Assert.assertEquals(21, getHandValue(CardValue.ACE, CardValue.KING));
        Assert.assertEquals(12, getHandValue(CardValue.EIGHT, CardValue.FOUR));
        Assert.assertEquals(14, getHandValue(CardValue.JACK, CardValue.FOUR));
        Assert.assertEquals(20, getHandValue(CardValue.QUEEN, CardValue.KING));
        Assert.assertEquals(20, getHandValue(CardValue.KING, CardValue.KING));
        Assert.assertEquals(20,
                            getHandValue(CardValue.TWO, CardValue.THREE, CardValue.FOUR, CardValue.FIVE, CardValue.SIX));
        Assert.assertEquals(28, getHandValue(CardValue.TWO, CardValue.SIX, CardValue.KING, CardValue.TEN));
        Assert.assertEquals(34, getHandValue(CardValue.SEVEN, CardValue.EIGHT, CardValue.NINE, CardValue.TEN));
    }


    @Test
    public void testCardValueWithAces()
    {
        Assert.assertEquals(21, getHandValue(CardValue.ACE, CardValue.KING));
        Assert.assertEquals(15, getHandValue(CardValue.ACE, CardValue.FOUR));
        Assert.assertEquals(21,
                            getHandValue(CardValue.ACE,
                                         CardValue.TWO,
                                         CardValue.THREE,
                                         CardValue.FOUR,
                                         CardValue.FIVE,
                                         CardValue.SIX));
        Assert.assertEquals(22,
                            getHandValue(CardValue.ACE,
                                         CardValue.ACE,
                                         CardValue.TWO,
                                         CardValue.THREE,
                                         CardValue.FOUR,
                                         CardValue.FIVE,
                                         CardValue.SIX));
        Assert.assertEquals(13, getHandValue(CardValue.ACE, CardValue.ACE, CardValue.ACE));
    }


    @Test
    public void testBlackjack()
    {
        Assert.assertFalse(createHand(CardValue.ACE).isBlackJack());
        Assert.assertFalse(createHand(CardValue.ACE, CardValue.EIGHT).isBlackJack());
        Assert.assertTrue(createHand(CardValue.ACE, CardValue.KING).isBlackJack());
        Assert.assertTrue(createHand(CardValue.ACE, CardValue.JACK).isBlackJack());
        Assert.assertTrue(createHand(CardValue.QUEEN, CardValue.ACE).isBlackJack());
        Assert.assertTrue(createHand(CardValue.KING, CardValue.ACE).isBlackJack());
        Assert.assertFalse(createHand(CardValue.KING, CardValue.ACE, CardValue.FIVE).isBlackJack());
    }


    private int getHandValue(CardValue... cardValues)
    {
        Hand hand = createHand(cardValues);

        return hand.getValue();
    }


    private Hand createHand(CardValue... cardValues)
    {
        Hand hand = new Hand();
        for (CardValue cardValue : cardValues)
        {
            hand.addCard(new Card(cardValue, Suit.CLUB));
        }
        return hand;
    }
}
