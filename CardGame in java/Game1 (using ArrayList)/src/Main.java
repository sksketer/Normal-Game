import operations.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Print p = new Print();
        Components cmp = new Components();

        ArrayList<Integer> playerCards = new ArrayList<Integer>();
        ArrayList<Integer> computerCards = new ArrayList<Integer>();
        int playingCard=5, computerMove=1, playerMove=0, computerFetchCard, playerFetchCard, computerHands=0, playerHands=0, round=1;

        cmp.totalCards();

        cmp.addCard(computerCards);
        Collections.sort(computerCards);
        p.Sop(" ");

        cmp.addCard(playerCards);
        cmp.display(playerCards, "Player Cards: ");

        while(playingCard != 0)
        {
            if(computerMove >= playerMove)
            {
                p.Sop(" ");
                p.Sop("-------------------------------\n");
                p.pf("Round ");p.pf(round);p.Sop(" ");

                p.Sop("Computer Turns");
                computerFetchCard = cmp.fechCard(computerCards);
                p.Sop(computerFetchCard);
                computerCards.remove(computerCards.indexOf(computerFetchCard));

                p.Sop("Player Turns");
                cmp.display(playerCards, "Your Cards: ");
                playerFetchCard = sc.nextInt();
                playerCards.remove(playerCards.indexOf(playerFetchCard));

                playingCard--;
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
            else
            {
                p.Sop("-------------------------------\n");
                p.pf("Round ");p.pf(round);p.Sop(" ");

                p.Sop("Player Turns");
                cmp.display(playerCards, "Your Cards: ");
                playerFetchCard = sc.nextInt();
                playerCards.remove(playerCards.indexOf(playerFetchCard));

                p.Sop("Computer Turns");
                computerFetchCard = cmp.fechCard(computerCards);
                p.Sop(computerFetchCard);
                computerCards.remove(computerCards.indexOf(computerFetchCard));

                playingCard--;
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

        p.Sop("-------------------------------\n");
        p.pf("Player score: "); p.Sop(playerHands);
        p.pf("Computer score: "); p.Sop(computerHands);

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
