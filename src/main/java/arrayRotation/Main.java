package arrayRotation;
public class Main {
    public static void main(String[] args) {
        BloomFilter<String> filter = new BloomFilter<>(1024,
                s -> s.hashCode(),
                s -> s.hashCode() * s.length());

        String element = "Hello World";
        filter.add(element);

        System.out.println("Does BloomFilter contain 'Hello World'? " + filter.contains("Hello World"));
        System.out.println("Does BloomFilter contain 'Goodbye World'? " + filter.contains("Goodbye World"));
    }
}