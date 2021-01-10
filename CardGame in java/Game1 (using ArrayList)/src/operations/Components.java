package operations;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Components
{
        Scanner sc = new Scanner(System.in);
        Print p = new Print();


        static int[] arr = new int[8];

        public void totalCards()
        {
            int n=8;
            p.Sop("Enter 8 Cards");
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
        }

        public int getRandom()
        {
            return arr[new Random().nextInt(arr.length - 1)];
        }

        public ArrayList<Integer> addCard(ArrayList<Integer> al)
        {
            Components cmp = new Components();
            int n=5;
            for(int i=0; i<n; i++)
            {
                int temp = cmp.getRandom();
                al.add(temp);
            }
            return al;
        }

        public void display(ArrayList<Integer> al, String name)
        {
            int n = al.size();
            p.pf(name);
            for(int i=0; i<n; i++)
            {
                p.pf(al.get(i));
                p.pf(" ");
            }p.Sop(" ");
        }

        public int fechCard(ArrayList<Integer> al)
        {
            int card, value;
            Random rn = new Random();
            value = rn.nextInt((al.size()) - (al.size())/2) + (al.size())/2;
            card = al.get(value);

            return card;
        }
        public int fetchCard(ArrayList<Integer> al, int playerFetchCard)
        {
            int card = al.get(0);

            for(int i=0; i<al.size(); i++)
            {
                if(playerFetchCard < al.get(i))
                {
                    card = al.get(i);
                    break;
                }
                else
                {
                    card = al.get(0);
                    break;
                }
            }

            return card;
        }
}
