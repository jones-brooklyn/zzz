package com.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.blackjack.tracker.HandEvaluator;
import com.blackjack.tracker.HandResult;
import com.blackjack.util.Card;
import com.blackjack.util.DiscardPile;
import com.blackjack.util.Hand;
import com.blackjack.util.PlayerMove;
import com.blackjack.util.Shue;

public class Dealer
{
    private Hand          dealerHand;
    private Shue          shue;

    private List<Player>  players;
    private DiscardPile   discardPile;
    private HandEvaluator handEvaluator;


    public Dealer(Shue shue,
                  Player player)
    {
        dealerHand = new Hand();
        this.shue = shue;
        this.players = new ArrayList<Player>();
        players.add(player);
        discardPile = new DiscardPile();
        handEvaluator = new HandEvaluator();
    }


    public void deal()
    {
        while (!shue.isReshuffleNeeded())
        {
            deal1Card();
            deal1Card();

            if (isDealerBlackJack())
            {
                handleDealerBlackJack();
            }
            playersPlayHand();

            playDealerHand();

            outputResults();
            handleResults();
        }

        reshuffle();
    }


    private void reshuffle()
    {
        shue.addCardsToShue(discardPile.clearDiscardPile());
    }


    private void handleResults()
    {
        for (Player player : players)
        {
            // evaluate and pay
            HandResult handResult = handEvaluator.getHandResult(player.getHand(), dealerHand);

            discardPile.addHand(player.getHand());
        }

        discardPile.addHand(dealerHand);
    }


    private void handleDealerBlackJack()
    {
        for (Player player : players)
        {
            if (player.getHand().isBlackJack())
            {
                ; // even money
            }
            else
            {
                ; // player loss
            }

            discardPile.addHand(player.getHand());
        }
    }


    private boolean isDealerBlackJack()
    {
        return dealerHand.isBlackJack();
    }


    private void deal1Card()
    {
        dealPlayers();
        dealToDealer();
    }


    private void outputResults()
    {
        System.out.println("Player hand");
        System.out.println(players.get(0).getHand());
        System.out.println(players.get(0).getHand().getValue());

        System.out.println("\nDealer hand");
        System.out.println(dealerHand);
        System.out.println(dealerHand.getValue());

        System.out.println(handEvaluator.getHandResult(players.get(0).getHand(), dealerHand));
    }


    private void playersPlayHand()
    {
        for (Player player : players)
        {
            PlayerMove playerMove = player.getNextMove();
            while (notBustedAndNotStaying(playerMove, player.getHand()))
            {
                if (playerMove.equals(PlayerMove.HIT))
                {
                    player.addCardToHand(getNextCardFromShue());
                }

                playerMove = player.getNextMove();
            }
        }
    }


    private boolean notBustedAndNotStaying(PlayerMove playerMove,
                                           Hand playerHand)
    {
        return !playerHand.isBust() && !playerMove.equals(PlayerMove.STAY);
    }


    private void dealToDealer()
    {
        dealerHand.addCard(getNextCardFromShue());
    }


    private void dealPlayers()
    {
        for (Player player : players)
        {
            player.addCardToHand(getNextCardFromShue());
        }
    }


    public Card getNextCardFromShue()
    {
        return shue.getNextCard();
    }


    public void playDealerHand()
    {
        if (dealerHand.isBlackJack())
        {
            return;
        }

        if (dealerHand.isSoftSevenTeen())
        {
            dealToDealer();
        }

        while (dealerHand.isSixteenOrUnder())
        {
            dealToDealer();
        }
    }
}
