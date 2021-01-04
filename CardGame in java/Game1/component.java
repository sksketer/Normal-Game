package game;

public class component
{
    Print p = new Print();

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
        int[] newArray = new int[arr.length-1];
        for(int i=0; i<arr.length-1; i++)
        {
            newArray[i] = arr[i];
        }
        for(int i=delIndex; i<arr.length-1; i++)
        {
            newArray[i] = arr[i+1];
        }

        return newArray;
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

}

