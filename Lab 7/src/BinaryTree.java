import java.util.*;
public class BinaryTree {
    Node root;

    BinaryTree(String eng, String esp){
        root = new Node(eng,esp);
    }

    BinaryTree(){
        root = null;
    }

    public void insert(String eng, String esp){
        Node newNode = new Node(eng,esp);
        if(root == null){
            root = newNode;
           System.out.println("Root Created: " + root.EnglishWord);
        }
        else{
            Node curr = root;
            Node parent;
            System.out.println("Current Node line 20: " + curr.EnglishWord);
            while(true){
                parent = curr;
                System.out.println("Line 24 parent: " + parent.EnglishWord);
                String parentWord = parent.EnglishWord;
                String newWord = newNode.EnglishWord;

                System.out.println(parentWord.compareTo(newWord) + " " + parentWord + " " + newWord);
                int compare = parent.EnglishWord.compareTo(newNode.EnglishWord);
                System.out.println("Compare value between " + parent.EnglishWord + " and " + newNode.EnglishWord + " Value: " + compare);
                if(compare < 0){   /*left child  newNode.EnglishWord < curr.EnglishWord (Lexicographically smaller)*/
                    curr = curr.rightChild;
                    if(curr == null){
                        parent.rightChild = newNode;
                        System.out.println("Line 32: Insertion complete " + newNode.EnglishWord);
                        return;
                    }
                }
                else if (compare > 0){   /*right child newNode.EnglishWord > curr.EnglishWord (Lexicographically bigger)*/
                    curr = curr.leftChild;
                    if(curr == null){
                        parent.leftChild = newNode;
                        System.out.println("Line 40: Insertion complete " + newNode.EnglishWord);
                        return;
                    }
                }
//                else{ /*newNode.EnglishWord = curr.EnglishWord (Lexicographically the same) - secondary comparison. length of strings*/
//                    if(newNode.EnglishWord.length() < curr.EnglishWord.length()){ /*if word has same lexicographical value but is smaller become left child*/
//                        curr = curr.leftChild;
//                        if(curr == null){
//                            parent.leftChild = newNode;
//                            System.out.println("Line 49: Insertion complete " + newNode.EnglishWord);
//                            return;
//                        }
//                    }
//                    else{
//                        curr = curr.rightChild;
//                        if(curr == null){
//                            parent.rightChild = newNode;
//                            System.out.println("Line 57: Insertion complete " + newNode.EnglishWord);
//                            return;
//                        }
//                    }
//                }
                //System.out.println("Line 58: Insertion complete " + newNode.EnglishWord);
            }

        }
    }

    public String translate(Node curr, String eng){
        if(curr == null || curr.EnglishWord.equals(eng)){
            System.out.println();
            if(root == null){
                return "Word not found";
            }
            else{
                return curr.SpanishWord;
            }
        }
        else if(curr.EnglishWord.compareTo(eng)< 0){
            return translate(curr.leftChild,eng);
        }
        else{
            return translate(curr.rightChild,eng);
        }
    }

    public int height(Node currNode){
        if(currNode == null){
            return 0;
        }
        else{
            int left = height(currNode.leftChild);
            int right = height(currNode.rightChild);

            if(right>left){
                return (right + 1);
            }
            else{
                return (left + 1);
            }
        }
    }
}
