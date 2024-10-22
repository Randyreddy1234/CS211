import java.util.*;
public class Question2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Student's track record: ");
        String record = sc.nextLine();

        if(Passed(record.toUpperCase())){
            System.out.println("PASSED");
        }
        else{
            System.out.println("FAILED");
        }

    }

    public static boolean Passed(String record){
        int absent = 0, late = 0;

        for(int i = 0; i < record.length(); i++){
            if(late >= 3 || absent >= 2){
                break;
            }
            if(record.charAt(i) == 'A'){
                absent++;
                late = 0;
            }
            else if(record.charAt(i) == 'L'){
                late++;
            }
            else{
                late = 0;
            }
        }

        if(late >= 3 || absent >= 2){
            return false;
        }
        else{
            return true;
        }
    }
}
