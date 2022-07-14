package org.redquark.dope.bloomfilter;

public class BloomFilterMain {

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilterImpl(1 << 10);
        String[] animals = new String[]{
                "lion", "fish, ferret", "goat", "crab", "wolverine", "cow", "horse", "crow",
                "meerkat", "seal", "llama", "leopard", "rhinoceros", "warthog", "ape", "chipmunk",
                "elephant", "deer", "walrus", "panda", "pig", "parakeet", "beaver", "puma", "bison",
                "eagle", "owl", "fox", "anteater", "groundhog", "lamb", "parrot", "panther", "coyote",
                "koala", "ram", "squirrel", "moose", "Kitten", "Otter", "octopus", "iguana", "sheep",
                "dog", "giraffe", "camel", "kangaroo", "toad", "Tiger", "sloth", "raccoon", "alligator",
                "weasel", "rooster", "jaguar", "polar bear", "snake", "wombat", "bear", "wolf", "chameleon",
                "hedgehog", "newt", "donkey", "salamander", "mole", "bat", "gorilla", "skunk", "rabbit",
                "pony", "chimpanzee", "whale", "opossum", "monkey", "platypus", "buffalo", "zebra", "dolphin",
                "cat", "bull", "rat", "chinchilla", "reindeer", "armadillo", "antelope", "turtle", "puppy",
                "hippopotamus", "porcupine", "starfish", "hamster", "crocodile", "chicken", "lemur", "bumble bee",
                "ox", "bald eagle", "cheetah", "frog", "orangutan", "lizard", "yak", "mouse", "duck", "seahorse",
                "penguin", "ant", "spider", "ladybug", "butterfly", "worm", "dragonfly", "flamingo", "jellyfish",
                "moth", "ostrich", "peacock", "shark" };
        for (String animal : animals) {
            bloomFilter.insert(animal);
        }
        String[] animalsToSearch = new String[]{
                "anirudh", "lizard", "sparrow", "crane", "sharma", "nightingale", "bakar", "ant", "porcupine"
        };
        for (String animalToSearch : animalsToSearch) {
            String isPresent = bloomFilter.mightContain(animalToSearch) ? "Yes" : "No";
            System.out.println("Is " + animalToSearch + " present in the set? " + isPresent);
        }
        System.out.println("\nFalse positive rate: " +  bloomFilter.falsePositiveRate());
    }
}
