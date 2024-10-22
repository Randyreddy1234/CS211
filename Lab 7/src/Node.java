public class Node {
    String EnglishWord, SpanishWord;
    Node leftChild,rightChild;

    public Node(String eng, String esp){
        EnglishWord = eng;
        SpanishWord = esp;
        leftChild = rightChild = null;
    }
}
