import java.util.*;
public class Question1 {
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
        int n;
        String result = "";
        int longer = 0;
        if(word1.length() > word2.length()){
            n = word2.length();
            longer = 1;
        }
        else{
            n = word1.length();
            longer = 2;
        }

        for(int i =0; i < n; i++){
            result = result + word1.charAt(i) + word2.charAt(i);
        }

        if(longer == 1){
            result = result + word1.substring(n);
        }
        else if(longer == 2){
            result = result + word2.substring(n);
        }

        return result;
    }
}
