import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
    Node root;

    BinaryTree(int d){
        root = new Node(d);
    }

    BinaryTree(){
        root = null;
    }

    public void insert(int d){
        Node newNode = new Node(d);
        if(root == null){
            root = newNode;
        }
        else{
            Node curr = root;
            Node parent;

            while(true){
                parent = curr;

                if(newNode.data < curr.data){   /*left child*/
                    curr = curr.leftChild;
                    if(curr == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{                           /*right child*/
                    curr = curr.rightChild;
                    if(curr == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

   /* public static int levels(Node root){  to find specific element
        if(root == null){
            return 0;  //if nothing in tree
        }

        int levels = 0;

        Queue<Node> nodeQueue = new LinkedList<>();

        Node current;

        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            while(size-- > 0){
                current = nodeQueue.peek();
                nodeQueue.remove();
                if(current.rightChild != null){
                    nodeQueue.add(current.rightChild);
                }
                if(current.leftChild != null){
                    nodeQueue.add(current.leftChild);
                }
            }
        }
    }
    */

    public int hight(Node currNode){
        if(currNode == null){
            return 0;
        }
        else{
            int left = hight(currNode.leftChild);
            int right = hight(currNode.rightChild);

            if(right>left){
                return (right + 1);
            }
            else{
                return (left + 1);
            }
        }
    }
}
