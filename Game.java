package Programs;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("PLAYER 1 is +");
        System.out.println("PLAYER 2 is -");
        System.out.print("Enter a Base Number Range greter than 10 to 100 : ");
        System.out.println("");
        int n=sc.nextInt();
        int num, turn1=0, turn2=0, i=1, p=1;
        while(true)
        {
            if(p%2 == 0)
            {
                System.out.println("Player 2 chance  ");
            }
            else
            {
                System.out.println("Player 1 chance   ");
            }
            System.out.print("Enter Number: ");
            num=sc.nextInt();
            boolean random=ThreadLocalRandom.current().nextBoolean();
            if(random==true)
            {
                n=n+num;
                System.out.println(n);
                turn1++;
            }
            else 
            {
                n=n-num;
                System.out.println(n);
                turn2++;
            }
            p++;
            System.out.println("Round "+i+++" Completed..");
            
            if(n<=0)
            {
                System.out.println(n+" "+turn1+" "+turn2);
                break;
            }
            
        }
        if(turn1<turn2)
        {
            System.out.println("Player 1 win");
        }
        else if(turn2<turn1)
        {
            System.out.println("Player 2 win");
        }
        else
        {
            System.out.println("Match Draw");
        }
        
    }
    
}
