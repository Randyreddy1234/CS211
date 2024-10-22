import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class node{
    int height;
    node left, right;
    String english, spanish;
    node(String eng,String esp){
        english = eng;
        spanish = esp;
        height = 1;
    }
}

class AVLTree{
    node root;

    /*Getting height of tree*/
    int height(node N){
        if(N == null){
            return 0;
        }
        return N.height;
    }

    /*Function to get max of two heights*/
    int max(int a, int b){
        return (a>b) ? a : b;
    }

    /*Function to perform right rotate with subtree rooted in Y*/
    node rightRotate(node Y){
        node x = Y.left;
        node T2 = x.right;

        //perform rotation
        x.right = Y;
        Y.left = T2;

        //update heights
        Y.height = max(height(Y.left), height(Y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /*Function to perform right rotate with subtree rooted in Y*/
    node leftRotate(node x){
        node y = x.right;
        node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /*Getting balance factor of node N*/
    int getBalance(node N){
        if(N == null){
            return 0;
        }
        return height(N.left)-height(N.right);
    }

    /*Insertion Method*/
    node insert(node N, String eng, String esp){
        //Step 1 - perform normal BST insertion
        if(N == null){
            //System.out.println("Word inserted: " + eng);
            return (new node(eng,esp));
        }
        else if(eng.compareTo(N.english) < 0){  //eng less than N.english Lexicographically
            N.left = insert(N.left,eng,esp);
            // System.out.println("left Child Insert: " + eng);
        }
        else if(eng.compareTo(N.english) > 0){  //eng greater than N.english
            N.right = insert(N.right,eng,esp);
            //System.out.println("right Child Insert");
        }
        else{
            return N; //no duplicates allowed
        }

        //Step 2 - Update height of this ancestor node
        N.height = 1 + max(height(N.left), height(N.right));

        //Step 3 - Get balance factor of this ancestor node to check whether this node became unbalanced
        int balanceFactor = getBalance(N);
        //this.preorder(root,1);

        //if node became unbalanced need to check cases to see how to rotate
        //left left case
        if(balanceFactor > 1 && eng.compareTo(N.left.english) < 0){
            //System.out.println("Left Left Case " + N.english);
            return rightRotate(N);
        }
        //System.out.println("Balance Factor: " + balanceFactor);
        //right right case
        if(balanceFactor < -1 && eng.compareTo(N.right.english) > 0){
            //System.out.println("right right Case" + N.english);
            return leftRotate(N);
        }

        //left right case
        if(balanceFactor > 1 && eng.compareTo(N.left.english) > 0){
            //System.out.println("Left right Case" + N.english);
            N.left = leftRotate(N.left);
            return rightRotate(N);
        }

        //right left case
        if(balanceFactor < -1 && eng.compareTo(N.right.english) < 0){
            //System.out.println("right Left Case" + N.english);
            N.right = rightRotate(N.right);
            return leftRotate(N);
        }

        return N;
    }

    /*to print out order of transversal of tree*/
    void preorder(node N, int count){
        if (N != null) {
            System.out.print(N.english + " " + count + " ");
            preorder(N.left,count + 1);
            preorder(N.right, count + 1);
        }
    }

    String translate(node N, String eng){
        //System.out.println(curr.english); //testing
        if(N == null){
            //if(root == null){
            return "Word not found";
            //}
        }
        else if(eng.equals(N.english)){
            return N.spanish;
        }
        else if(eng.compareTo(N.english) < 0){
            return translate(N.left,eng);
        }
        else{
            //System.out.println("right");
            return translate(N.right,eng);
        }

    }

    static int nodeCount(node node)
    {
        if (node == null)
            return 0;

        else
            return nodeCount(node.left)
                    + nodeCount(node.right) + 1;
    }

    public static void main(String [] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("EngEsp.csv"));
        Scanner in = new Scanner(System.in);
        sc.useDelimiter(",|\r?\n");
        AVLTree tree = new AVLTree();
        String engSen,espSen = "";

        while (sc.hasNext()){
            String eng = sc.next().trim();
            String esp = sc.next().trim();
            //System.out.println(eng + " " + esp);
            tree.root = tree.insert(tree.root,eng,esp);// trim whitespaces and insert into binary tree
        }
        System.out.println("File read in successfully");
        sc.close();

        System.out.println("Enter a sentence to be translated:");
        engSen = in.nextLine();

        String [] engWords = engSen.split(" ");

        for(String word : engWords){
            System.out.println(word);
            espSen = espSen + tree.translate(tree.root,word) + " ";
        }

        System.out.println(espSen);

        System.out.println("Height of tree: " + tree.height(tree.root) + " levels");
        System.out.println("nodes in tree: " + nodeCount(tree.root));

    }
}