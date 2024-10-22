import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean input = true;

        System.out.println("Enter words to be stored:");

        while(input){
            String in = sc.nextLine();
            if(in.equals("END")){
                input = false;
                list.printFromHead();
            }
            else{
                list.insert(in);
            }
        }
    }
}
