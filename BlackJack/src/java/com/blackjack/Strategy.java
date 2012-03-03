package com.blackjack;

import com.blackjack.util.PlayerMove;
import com.blackjack.util.Hand;

public interface Strategy
{
    PlayerMove getNextMove(Hand hand);
}
