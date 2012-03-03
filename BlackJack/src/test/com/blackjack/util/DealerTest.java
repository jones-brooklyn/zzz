package com.blackjack.util;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.Dealer;
import com.blackjack.HitUnder17Strategy;
import com.blackjack.Player;

public class DealerTest
{
    private Dealer dealer;


    @Before
    public void setup()
    {
        dealer = new Dealer(new Shue(6), new Player(new HitUnder17Strategy()));
    }


    @Test
    public void testDeal()
    {
        dealer.deal();
    }
}
