
public class HashTable<K, V> {
    int tableSize = 10;
    
    // Going to use a manual linkedlist for storing key value pairs
    // Linkedlist becasue Hash function can cause same index for different value.
    // When the hashed index of the array is found, we need to store and retrieve key and values
    // considering that different keys can have same array index (because of the hash)
    // So when inserting or retrieving, go to the index then search the linkedlist for the key
    @SuppressWarnings("unchecked")
    private Node<K, V>[] table = new Node[tableSize];

    public HashTable(){}

    private int getHash(K key){
        return key.hashCode() % tableSize;
    }

    public void put(K key, V value){
        int index = getHash(key);

        Node<K, V> node = new Node<>(key, value);

        if(table[index] == null)
            table[index] = node;
        else{
            Node<K, V> lastNode = findEndOfList(table[index], key);

            if(lastNode != null)
                lastNode.next = node;
            else
                System.out.println("Key Already exists");
        }
    }

    public V get(K key){
        Node<K, V> node = findKeyNode(key);
        
        if(node != null)
            return node.value;

        return null;
    }

    public boolean contains(K key){
        Node<K, V> node = findKeyNode(key);

        if(node == null)
            return false;
        
        return true;
    }

    public void remove(K key){
        Node<K, V> node = findKeyNode(key);

        if(node == null) return;

        if(node.next != null){
            // Here, i'm just sliding the rest of the list 1 node, the node to be removed
            Node<K, V> prevNode = new Node<>();

            while(node.next != null){
                node.key = node.next.key;
                node.value = node.next.value;

                prevNode = node;
                node = node.next;
            }
            prevNode.key = null;
            prevNode.value = null;

            return;
        }

        // If the node has no connected node, then set node as null
        node.key = null;
        node.value = null;      
    }

    private Node<K, V> findEndOfList(Node<K, V> node, K key){
        while(node.next != null){
            if(node.key != key)
                node = node.next;
            else
                return null;
        }
        return node;
    } 

    private Node<K, V> findKeyNode(K key){
        int index = getHash(key);

        Node<K, V> node = table[index];

        while(node != null){
            if(node.key == key)
                return node;
            
            node = node.next;
        }

        return null;
    }
}
