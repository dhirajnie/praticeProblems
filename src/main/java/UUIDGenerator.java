

import java.util.UUID;

public class UUIDGenerator {


    public static void main(String[] args) {

        // this is almost unqiue
        // With just 103 trillion (about
        // ) randomly generated UUIDs, the probability of at least one collision is roughly 50%.
        String uuid = UUID.randomUUID().toString();

        /*
             timestamp + machineIdentifier + processIdentifier + counter;
         */
    }
}
