package com.blackjack;

import com.blackjack.util.PlayerMove;
import com.blackjack.util.Hand;

public class HitUnder17Strategy implements Strategy
{

    @Override
    public PlayerMove getNextMove(Hand hand)
    {
        return hand.getValue() < 17 ? PlayerMove.HIT : PlayerMove.STAY;
    }
}
