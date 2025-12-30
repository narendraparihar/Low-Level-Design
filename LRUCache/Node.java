public class Node<K, V> {
    K key;
    V val;
    Node<K, V> prev, next;

    Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
