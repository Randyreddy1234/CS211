import java.util.*;
public class Part2 {
    public static void main(String [] args){
        PriorityQueue<Tree> queue = new PriorityQueue<Tree>(); //Priority queue for object Tree
        Scanner sc = new Scanner(System.in);

        HashMap<Character, String> huffmanCodes = new HashMap<>();

        System.out.print("Enter a sentence: ");
        String sen = sc.nextLine().toLowerCase();
        String code = "", result = "";
        char [] let = sen.toCharArray();
        int [] ascii = new int[127];

        for(char i : let){
            ascii[i]++;
        }

        for(int i = 32; i < 127; i++){
            if(ascii[i] != 0){
                Tree temp = new Tree();
                temp.root = new Node();
                temp.root.letter = (char)i;
                temp.frequency = ascii[i];
                queue.add(temp);
            }
        }

        //System.out.println("Line 26 QSize: " + queue.size());
        while(queue.size()>1){
            //System.out.println("Line 27 QSize: " + queue.size());
            Tree min1 = queue.poll();
            Tree min2 = queue.poll();

            Tree in = new Tree();
            in.frequency = min1.frequency + min2.frequency;
            in.root = new Node();
            in.root.leftChild = min1.root;
            in.root.rightChild = min2.root;

            queue.add(in);
        }

        //System.out.println("Line 40 QSize: " + queue.size());
        Tree huffmanTree = queue.poll();

        huffmanCodes = huffmanTree.huffmanCodes(huffmanTree.root,code,huffmanCodes);

        for (char letter : huffmanCodes.keySet()) {
            System.out.println("Letter: " + letter + ", Code: " + huffmanCodes.get(letter));
        }

        for(int i = 0; i < sen.length(); i++){
            char c = sen.charAt(i);
            result += huffmanCodes.get(c);
        }

        System.out.println("Encoded Message: " + result);
    }
}