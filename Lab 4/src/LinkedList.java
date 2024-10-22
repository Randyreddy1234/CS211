public class LinkedList {
    private static Node head;  //to reference first element in link lists

    public LinkedList(){  //default constructor to create the link list
        head = null;  //sets the first link to null for empty linked list
    }

    public boolean isEmpty(){
        return (head == null);
    }


    public static void  insert(String in){  //inserting element at the head
        Node newNode = new Node(in); //Create new node and store data in it from default constructor
        newNode.next = head; //make the next node within newNode reference the old head node
        head = newNode; //make head of linked list reference newNode as inserted at the head
    }

    public static void printFromHead(){
        Node curr = head;

        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    /*
    public void printRev(LinkedList list){
        Node printLink = list.tail;

        while(printLink.prev != null){
            printLink = tail.next;
        }
        while(printLink != list.head){
            System.out.println(printLink.data);
            printLink = printLink.prev;
        }
        System.out.println(printLink.data);
    }
     */
}
