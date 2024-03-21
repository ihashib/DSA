public class Node <K, V>{
    K key = null;
    V value = null;
    Node<K,V> next = null;
    
    public Node(K key, V value, Node<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public Node(){}
}
