import java.util.*;
public class Part1 {
    public static String frequency(String s){
        s = s.toLowerCase();
        String result = "";
        char [] let = s.toCharArray();
        int [] ascii = new int[127];

        for(char i : let){
            ascii[i]++;
        }

        for(int i = 0; i < 127; i++){
            if(ascii[i] != 0){
                result += "'" + (char)(i) + "' had a frequency of " + ascii[i] + "\n";
            }
        }
        return result;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sen = sc.nextLine();

        System.out.println(frequency(sen));
    }
}
