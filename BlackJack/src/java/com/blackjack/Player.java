package com.blackjack;

import com.blackjack.util.Card;
import com.blackjack.util.Hand;
import com.blackjack.util.PlayerMove;

public class Player
{
    private final Hand     hand;
    private final Strategy strategy;


    public Player(Strategy strategy)
    {
        this.strategy = strategy;
        this.hand = new Hand();
    }


    public void addCardToHand(Card nextCardFromShue)
    {
        hand.addCard(nextCardFromShue);
    }


    public PlayerMove getNextMove()
    {
        return strategy.getNextMove(hand);
    }


    public Hand getHand()
    {
        return hand;
    }

}
