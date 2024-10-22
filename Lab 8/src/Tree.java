import java.util.HashMap;

public class Tree implements Comparable<Tree> {
    public Node root;             //first node of tree
    public int frequency = 0;    //this is the weighting of the tree so that it can be ordered


    public Tree() {                // constructor
        root = null;             // no nodes in tree yet
    }

//the PriorityQueue needs to be able to somehow rank the objects in it
//thus, the objects in the PriorityQueue must implement an interface called Comparable
//the interface requires you to write a compareTo() method so here it is:

    public int compareTo(Tree object) { //
        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree
            return 1; //return 1 if freq > object.freq
        } else if (frequency - object.frequency < 0) {
            return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller - return -1 if freq < object.freq
        }
        return 0;   //return 0 if they're the same
    }

    //Part 3
    public static HashMap<Character, String> huffmanCodes(Node root,String s,HashMap<Character,String> map){
        if(root == null){
            return map;
        }
        if(root.leftChild == null && root.rightChild == null /*&& Character.isLetter(root.letter)*/){
            map.put(root.letter,s);
        }else {
            huffmanCodes(root.leftChild, s + "0", map);
            huffmanCodes(root.rightChild, s + "1", map);
        }

        return map;
    }
}
