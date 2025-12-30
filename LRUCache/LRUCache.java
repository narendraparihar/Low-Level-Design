import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> dll;
    private int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList<>();
    }

    public synchronized Node<K, V> get(K key) {
        if (map.get(key) == null)
            return null;

        Node<K, V> node = map.get(key);
        dll.moveToFirst(node);
        return node;
    }

    public synchronized void put(K key, V value) {
        if (map.get(key) != null) {
            Node<K, V> node = map.get(key);
            node.val = value;
            dll.moveToFirst(node);
        } else {
            if (capacity == map.size()) {
                Node<K, V> node = dll.removeLast();
                if (node != null)
                    map.remove(node.key);
            }
            Node<K, V> node = new Node<K, V>(key, value);
            dll.addFirst(node);
            map.put(key, node);
        }
    }

}
