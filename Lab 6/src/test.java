import java.util.Scanner;

public class test {

    public static void main(String[] args)
    {
        // int num = findSequence(9);

        // System.out.print("Steps: " + num);

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the how many numbers to check: ");
        long finish = sc.nextLong();
        long startCon = 1;
        long endCon = 1;
        int count = 0;
        int largestRange = 0;

        sc.close();

        for(int i = 1; i <= finish; i++)
        {
            if(findSequence(startCon) == findSequence(endCon))
            {
                //Increment end of range to keep searching
                endCon++;
                count++;
            }
            else
            {
                if(count > largestRange)
                {
                    largestRange = count;
                }
                //Start becomes end, end continues counting
                startCon = endCon;
                endCon++;
                count = 0;
            }
            if (largestRange > 100)
            {
                System.out.println(largestRange);
                System.out.println(startCon);
                break;
            }

        }

        System.out.println("Largest number of consecutive numbers in your range: " + largestRange);
        // System.out.println("Number of steps: " + findSequence(startCon--));
        // System.out.println("Last number in largest range: " + startCon--);
    }

    public static long findSequence(long num)
    {
        if(num == 1)
        {
            return 0;
        }

        if(num % 2 == 0)
        {
            return 1 + findSequence(num/2);
        }
        else
        {
            return 1 + findSequence((num*3)+1);
        }
    }
}