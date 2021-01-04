package game;

import java.util.Scanner;

public class cardGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Print p = new Print();
        var cmp = new component();

        /* int numberOfCards = 10;
        String[] totalCards = new String[numberOfCards];

        for(int i=0; i<numberOfCards; i++)
        {
            int values = (int)(Math.random() * 10);
            totalCards[i] = Integer.toString(values);
        } */

        int playingCards = 8;

        int[] computerCards = new int[playingCards];
        int[] playerCards  = new int[playingCards];

        for(int i=0; i<playingCards; i++)
        {
            int values = (int)(Math.random() * 10); 
            computerCards[i] = (values);
        }
        cmp.sort(computerCards, playingCards);

        for(int  i=0; i<playingCards; i++)
        {
            int value = (int)(Math.random() * 10);
            playerCards[i] = (value);
        }

        p.Sop("Computer Cards");
        cmp.displayCards(computerCards, playingCards);

        p.Sop("Player Cards");
        cmp.displayCards(playerCards, playingCards);

        int computerMove=1, playerMove=0, computerFetchCard, playerFetchCard, computerHands=0, playerHands=0, round=1;

        while(playingCards != 0)
        {
            if(computerMove >= playerMove)
            {
                p.pf("Round ");p.pf(round);p.Sop(" ");
                p.Sop("Computer Turns");
                cmp.displayCards(computerCards, playingCards);
                computerFetchCard = cmp.fetchCard(computerCards, playingCards);
                p.Sop(computerFetchCard);

                p.Sop("Players Turn");
                p.pf("Your Cards: ");
                cmp.displayCards(playerCards, playingCards);
                playerFetchCard = sc.nextInt();
                playingCards--;
                int ind = cmp.findIndex(playerCards, playerFetchCard);
                p.pf("index is: ");
                p.Sop(ind);
                cmp.swapArrayElements(playerCards, ind);
                p.Sop("-------------------------------\n");

                if(playerFetchCard > computerFetchCard)
                {
                    playerMove++;
                    playerHands++;
                }
                else
                {
                    computerMove++;
                    computerHands++;
                }
            }
            else if(computerMove < playerMove)
            {
                p.pf("Round ");p.pf(round);p.Sop(" ");
                p.Sop("Player Turns");
                p.pf("Your Cards: ");
                cmp.displayCards(playerCards, playingCards);
                playerFetchCard = sc.nextInt();

                p.Sop("Computer Turns");
                cmp.displayCards(computerCards, playingCards);
                computerFetchCard = cmp.fetchCard(computerCards, playingCards, playerFetchCard);
                p.Sop(computerFetchCard);
                playingCards--;
                cmp.swapArrayElements(computerCards, 0);
                p.Sop("-------------------------------\n");

                if(playerFetchCard > computerFetchCard)
                {
                    playerMove++;
                    playerHands++;
                }
                else
                {
                    computerMove++;
                    computerHands++;
                }
            }
            round++;
        }

        if(computerHands > playerHands)
        {
            p.Sop("COMPUTER WIN");
        }
        else if(playerHands > computerHands)
        {
            p.Sop("YOU WIN");
        }
        else
        {
            p.Sop("Draw match");
        }


        sc.close();
    }    
}
