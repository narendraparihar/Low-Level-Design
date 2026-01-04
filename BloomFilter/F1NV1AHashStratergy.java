import java.nio.charset.StandardCharsets;

public class F1NV1AHashStratergy implements HashStratergy {
    private static final long fnv_prime = 0x100000001b3L;
    private static final long fnv_offset_basis = 0xcbf29ce484222325L;

    @Override
    public long hash(String data) {

        long hash = fnv_offset_basis;
        for (byte b : data.getBytes(StandardCharsets.UTF_8)) {
            hash ^= b;
            hash *= fnv_prime;
        }

        return hash;
    }
}
