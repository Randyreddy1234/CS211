import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Test.csv"));
        sc.useDelimiter(",|\r?\n");
        BinaryTree bTree = new BinaryTree();

        while (sc.hasNext()){
            //System.out.println(sc.next().trim() + " " + sc.next().trim());
            bTree.insert(sc.next().trim(), sc.next().trim());// trim whitespaces and insert into binary tree
        }
        sc.close();

        //System.out.println("English: " + bTree.root.EnglishWord + "\nSpanish: " + bTree.root.SpanishWord);
       // System.out.println(bTree.root.rightChild.EnglishWord);
        //System.out.println(bTree.root.rightChild.rightChild.EnglishWord);
        System.out.println(bTree.root.EnglishWord);
        System.out.println(bTree.root.leftChild.EnglishWord);
        System.out.println(bTree.root.leftChild.leftChild.EnglishWord);
        System.out.println(bTree.translate(bTree.root, "dog"));
        //System.out.println(bTree.translate(bTree.root, "milk"));
        //System.out.println(bTree.translate(bTree.root, "hello"));
        //System.out.println(bTree.translate(bTree.root, "hello"));

        System.out.println(bTree.height(bTree.root));

    }
}
