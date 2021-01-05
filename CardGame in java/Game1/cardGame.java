package game;

import java.util.Scanner;


public class cardGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        cardGame p = new cardGame();
        cardGame cmp = new cardGame();

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

        // p.Sop("Computer Cards");
        // cmp.displayCards(computerCards, playingCards);

        p.Sop("Player Cards");
        cmp.displayCards(playerCards, playingCards);

        int computerMove=1, playerMove=0, computerFetchCard, playerFetchCard, computerHands=0, playerHands=0, round=1;

        while(playingCards != 0)
        {
            if(computerMove >= playerMove)
            {
                p.Sop("-------------------------------\n");
                p.pf("Round ");p.pf(round);p.Sop(" ");
                p.Sop("Computer Turns");
                computerFetchCard = cmp.fetchCard(computerCards, playingCards);
                p.Sop(computerFetchCard);

                p.Sop("Players Turn");
                p.pf("Your Cards: ");
                cmp.displayCards(playerCards, playingCards);
                playerFetchCard = sc.nextInt();
                playingCards--;
                int ind = cmp.findIndex(playerCards, playerFetchCard);
                cmp.swapArrayElements(playerCards, ind);

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
                p.Sop("-------------------------------\n");
                p.pf("Round ");p.pf(round);p.Sop(" ");
                p.Sop("Player Turns");
                p.pf("Your Cards: ");
                cmp.displayCards(playerCards, playingCards);
                playerFetchCard = sc.nextInt();
                playingCards--;
                int ind = cmp.findIndex(playerCards, playerFetchCard);
                cmp.swapArrayElements(playerCards, ind);

                p.Sop("Computer Turns");
                computerFetchCard = cmp.fetchCard(computerCards, playingCards, playerFetchCard);
                p.Sop(computerFetchCard);
                playingCards--;
                cmp.swapArrayElements(computerCards, 0);

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
    
    public int[] sort(int[] arr, int n) 
    {
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < n - 1; i++) 
            {
                if (arr[i] > arr[i + 1]) 
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        return arr;
    }
    public int[] displayCards(int[] arr, int arrLength)
    {
        cardGame p = new cardGame();
        
        for(int i=0; i<arrLength; i++)
        {
            p.pf(arr[i]);
            p.pf(" ");
        }
        p.Sop(" ");

        return arr;
    }

    public int fetchCard(int[] arr, int arrLength)
    {
        int card;
        card = arr[arrLength-1];

        return card;
    }

    public int fetchCard(int[] arr, int arrLength, int pc)
    {
        int card;

        if(pc > arr[arrLength-1])
        {
            card = arr[0];

        }
        else
        {
            card = arr[arrLength-1];
        }


        return card;
    }

    public int[] swapArrayElements(int[] arr, int delIndex)
    {
        for(int i=delIndex; i<arr.length-1 ; i++)
        {
            arr[i]=arr[i+1];
        }
        
        return arr;
    }

    public int findIndex(int[] arr, int val)
    {
        int index=0;

        for(int i=0; i<arr.length; i++)
        {
            if(val == arr[i])
            {
                index = i;
                break;
            }
        }

        return index;
    }

    public void Sop(String msg)
    {
        System.out.println(msg);
    }
    public void Sop(int msg)
    {
        System.out.println(msg);
    }
    public void pf(String msg)
    {
        System.out.print(msg);
    }
    public void pf(int msg)
    {
        System.out.print(msg);
    }
}
