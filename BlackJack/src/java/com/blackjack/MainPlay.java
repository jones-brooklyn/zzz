package com.blackjack;

import com.blackjack.util.Shue;

public class MainPlay
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Player player = new Player(new HitUnder17Strategy());
        Dealer dealer = new Dealer(new Shue(6), player);

        dealer.deal();
    }

}
