package com.blackjack.util;

import junit.framework.Assert;

import org.junit.Test;

public class ShueTest
{
    public Shue shue;


    @Test
    public void testShueSize()
    {
        createShueAndVerifySize(2);
        createShueAndVerifySize(6);
    }


    @Test
    public void testShuffle()
    {
        shue = new Shue(1);
        shue.print();
        System.out.println("now shuffling");
        shue.shuffle();
        shue.print();

        // TODO enhance tests
    }


    private void createShueAndVerifySize(int numberOfDecks)
    {
        shue = new Shue(numberOfDecks);
        Assert.assertEquals(numberOfDecks * 52, shue.getNumberOfCards());
    }
}
