package org.redquark.dope.bloomfilter;

public class BloomFilterImpl implements BloomFilter {

    // Size of the bloom filter array
    private final int m;

    // Count of hash functions to be applied
    private final int k;

    // Array to represent filter
    private final int[] filter;

    // Total elements inserted in the filter
    private int n;

    public BloomFilterImpl(int m) {
        this.m = m;
        this.k = 3;
        this.filter = new int[this.m];
        this.n = 0;
    }

    @Override
    public void insert(String item) {
        // Get all the indices which should be set.
        int[] indices = getAllSetIndices(item);
        // Loop through all the indices and set their values to 1.
        for (int index : indices) {
            this.filter[index] = 1;
        }
        this.n++;
    }

    @Override
    public boolean mightContain(String item) {
        // Get all the bits after applying hash on this item.
        int[] indices = getAllSetIndices(item);
        // Loop through all the indices and check their respective values.
        for (int index : indices) {
            // If value at any of the index is 0, it means it is definite that
            // the item is not present in the set.
            if (filter[index] == 0) {
                return false;
            }
        }
        // If we reach here, it means values at all indices are 1, which means
        // that there is a possibility that the item is present in the set.
        return true;
    }

    @Override
    public double falsePositiveRate() {
        return Math.pow((1.0 - Math.exp(-(k * n) * 1.0 / m)), k);
    }

    private int[] getAllSetIndices(String item) {
        int hashOne = Math.abs(item.hashCode()) % this.m;
        int hashTwo = Math.abs(47 * item.hashCode()) % this.m;
        int hashThree = (int) Math.pow((Math.abs(53 * item.hashCode()) % this.m), 3) % this.m;
        return new int[]{hashOne, hashTwo, hashThree};
    }
}
