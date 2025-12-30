public class DoublyLinkedList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;

    DoublyLinkedList() {
        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);

        head.next = tail;
        tail.prev = head;

    }

    public void addFirst(Node<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node<K, V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public Node<K, V> removeLast() {
        Node<K, V> last = tail.prev;
        if (last == head)
            return null;
        remove(last);
        return last;
    }

    public void moveToFirst(Node<K, V> node) {
        remove(node);
        addFirst(node);
    }
}
