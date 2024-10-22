import java.util.*;
public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        BinaryTree bTree = new BinaryTree();
        boolean allowIn = true;

        while(allowIn){
            System.out.print("Enter number to insert into binary tree (enter 260402 to stop): ");
            int num = sc.nextInt();

            if(num != 260402){
                bTree.insert(num);
            }
            else{
                allowIn = false;
            }
        }

        System.out.println("The resulting binary tree has " + bTree.hight(bTree.root) + " levels.");

    }
}
