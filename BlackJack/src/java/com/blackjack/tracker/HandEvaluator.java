package com.blackjack.tracker;

import com.blackjack.util.Hand;

public class HandEvaluator
{
    public HandResult getHandResult(Hand playerHand,
                                    Hand dealerHand)
    {
        if (playerHand.isBust())
        {
            return HandResult.PLAYER_LOSE;
        }

        if (dealerHand.isBust())
        {
            return HandResult.PLAYER_WIN;
        }

        if (playerHand.getValue() == dealerHand.getValue())
        {
            return HandResult.PLAYER_PUSH;
        }

        return playerHand.getValue() > dealerHand.getValue() ? HandResult.PLAYER_WIN : HandResult.PLAYER_LOSE;
    }
}
