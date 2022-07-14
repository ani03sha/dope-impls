package org.redquark.dope.bloomfilter;

public interface BloomFilter {

    void insert(String item);

    boolean mightContain(String item);

    double falsePositiveRate();
}
