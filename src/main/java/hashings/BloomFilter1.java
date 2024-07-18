package hashings;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.commons.codec.digest.MurmurHash3;

public class BloomFilter1 {
    private static final int DEFAULT_SIZE = 1024;
    private final BitSet bitSet;
    private final int bitSetSize;
    private final int[] hashSeeds;

    public BloomFilter1(int bitSetSize, int hashFunctionCount) {
        this.bitSetSize = bitSetSize;
        this.bitSet = new BitSet(bitSetSize);
        this.hashSeeds = new int[hashFunctionCount];
        for (int i = 0; i < hashFunctionCount; i++) {
            hashSeeds[i] = i + 1; // Simple seed values for demonstration
        }
    }

    private int[] hash(String value) {
        int[] hashes = new int[hashSeeds.length];
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < hashSeeds.length; i++) {
            hashes[i] = Math.abs(MurmurHash3.hash32x86(bytes, 0, bytes.length, hashSeeds[i])) % bitSetSize;
        }
        return hashes;
    }

    public void add(String value) {
        int[] hashes = hash(value);
        for (int hash : hashes) {
            bitSet.set(hash);
        }
    }

    public boolean mightContain(String value) {
        int[] hashes = hash(value);
        for (int hash : hashes) {
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter1 bloomFilter = new BloomFilter1(DEFAULT_SIZE, 3);
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("dada");
        items.add("banana");

        // Adding items to the Bloom filter
        items.forEach(bloomFilter::add);

        // Checking if items might be in the Bloom filter
        System.out.println(bloomFilter.mightContain("apple"));  // true
        System.out.println(bloomFilter.mightContain("banana")); // true
        System.out.println(bloomFilter.mightContain("cherry")); // true
        System.out.println(bloomFilter.mightContain("date"));   // false (most likely)
    }
}