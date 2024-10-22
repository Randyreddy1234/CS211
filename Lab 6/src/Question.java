import java.util.*;
import java.io.*;

public class Question {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int count = 1,highest = 0;
        long start = 1, end = 1;

        System.out.print("Enter a number for end of range:");
        int num = sc.nextInt();

        for(int i = 1; i < num; i++){
            if(steps(i) == steps(i+1)){
                count++;
            }
            else{
                if(highest < count){
                    highest = count;
                }
                count = 1;
            }
        }

        System.out.println(highest);
    }

    public static long steps(long num){
        if(num == 1){
            return 0;
        }
        else if(num % 2 == 0){
            return steps(num/2) + 1;
        }
        else{
            return steps((num*3)+1) + 1;
        }
    }
}
