import java.util.*;
public class Question2{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first word:");
        String word1 = sc.nextLine();
        System.out.print("Enter the second word:");
        String word2 = sc.nextLine();

        //constraints
        if(word1.length() < 1 || word2.length() > 100){
            System.out.println("Invalid! Word 1 must not be less than 1 character and word 2 not greater than 100 characters.");
        }
        else if(word1.toLowerCase().equals(word1) && word2.toLowerCase().equals(word2)){
            System.out.println("Merged:" + mergeSort(word1,word2));
        }
        else{
            System.out.println("Both words inputted must be in lower case.");
        }
    }

    public static String mergeSort(String word1, String word2){
        int n = word1.length(), m = word2.length(),i=0,j=0;
        String result = "";
        int longer = 0;

        while(i<n && j < m){
            char a = word1.charAt(i), b = word2.charAt(j);

            if((int)a >= (int)b){
                result = result + b;
                j++;
            }
            else {
                result = result + a;
                i++;
            }
        }

        while(i < n){
            char a = word1.charAt(i);
            result = result + a;
            i++;
        }

        while(j < m){
            char b = word1.charAt(j);
            result = result + b;
            j++;
        }
        return result;
    }
}
