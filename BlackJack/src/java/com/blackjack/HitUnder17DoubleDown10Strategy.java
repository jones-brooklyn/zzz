package com.blackjack;

import com.blackjack.util.Hand;
import com.blackjack.util.PlayerMove;

public class HitUnder17DoubleDown10Strategy implements Strategy
{

    @Override
    public PlayerMove getNextMove(Hand hand)
    {
        if (hand.getValue() == 9 || hand.getValue() == 10)
        {
            return PlayerMove.DOUBLE_DOWN;
        }

        return hand.getValue() < 17 ? PlayerMove.HIT : PlayerMove.STAY;
    }
}
