import java.util.ArrayList;
import java.util.List;

public class BloomFilterDemo {
    public static void main(String[] args) {
        int bitSize = 10000;
        int numHashFunctions = 2;
        int expectedInsertion = 1000;

        List<HashStratergy> hashStratergies = List.of(
                HashStratrgyFactory.create(HashTypes.FNV1A),
                HashStratrgyFactory.create(HashTypes.DJB2));

        BloomFilter filter = new BloomFilter.BloomFilterBuilder()
                .withBitSetSize(bitSize)
                .withHashStratergies(hashStratergies)
                .withNumHashFunction(numHashFunctions)
                .build();

        System.out.println("adding " + expectedInsertion + " records in bloomfilter");
        List<String> insertedRecords = new ArrayList<>();
        for (int i = 0; i < expectedInsertion; i++) {
            String data = "user" + i + "@gmail.com";
            filter.add(data);
            insertedRecords.add(data);
        }

        System.out.println("checking false negative");
        int falseNegativeCount = 0;
        for (int i = 0; i < insertedRecords.size(); i++) {
            boolean isAvailable = filter.mightContain(insertedRecords.get(i));

            if (!isAvailable) {
                falseNegativeCount++;
            }
        }
        System.out.println("Total records returened as false negative " + falseNegativeCount);
        System.out.println("-----------------------");
        System.out.println("checking false Positive");

        int falsePositiveCount = 0;
        for (int i = 0; i < insertedRecords.size(); i++) {
            int count = 1000 + i;
            String data = "user" + count + "@gmail.com";
            boolean isAvailable = filter.mightContain(data);

            if (isAvailable) {
                falsePositiveCount++;
                System.out.println("string counted as available " + data);
            }
        }
        System.out.println("Total records returened as false Positive: " + falsePositiveCount);
    }
}
