public class LRUCacheDemo {
    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "IND");
        cache.put(2, "AUS");
        cache.put(3, "USA");

        System.out.println(cache.get(1).val);
        cache.put(4, "RUS");
        System.out.println(cache.get(2));

    }
}
