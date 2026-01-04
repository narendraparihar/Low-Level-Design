import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    private int bitSize;
    private BitSet bitSet;
    private List<HashStratergy> hashStratergy;

    BloomFilter(int bitSize, List<HashStratergy> hashStratergies) {
        this.bitSize = bitSize;
        this.bitSet = new BitSet(bitSize);
        this.hashStratergy = hashStratergies;
    }

    public void add(String data) {

        for (int i = 0; i < hashStratergy.size(); i++) {
            long hash = hashStratergy.get(i).hash(data);
            int index = (int) (Math.abs(hash % bitSize));
            bitSet.set(index);
        }
    }

    public boolean mightContain(String data) {
        for (int i = 0; i < hashStratergy.size(); i++) {
            long hash = hashStratergy.get(i).hash(data);
            int index = (int) (Math.abs(hash % bitSize));
            if (!bitSet.get(index)) {
                return false;
            }
        }

        return true;
    }

    public static class BloomFilterBuilder {
        private int bitSize;
        private List<HashStratergy> hashStratergy;
        private int numHashFunctions;

        public BloomFilterBuilder withBitSetSize(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Invalid bit size");
            }
            this.bitSize = size;
            return this;
        }

        public BloomFilterBuilder withNumHashFunction(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Invalid bit size");
            }
            this.numHashFunctions = size;
            return this;
        }

        public BloomFilterBuilder withHashStratergies(List<HashStratergy> hashStratergies) {
            if (hashStratergies.size() <= 0) {
                throw new IllegalArgumentException("At least one hash strategy must be provided.");
            }
            this.hashStratergy = hashStratergies;
            return this;
        }

        public BloomFilter build() {
            if (bitSize == 0 || numHashFunctions == 0 || hashStratergy == null) {
                throw new IllegalArgumentException("bitSize and hashStratergy must be provided");
            }

            if (numHashFunctions > hashStratergy.size()) {
                throw new IllegalArgumentException(
                        "Please provide " + this.numHashFunctions + "stratergy in hashStratrgyList");
            }

            return new BloomFilter(bitSize, hashStratergy);
        }
    }
}
