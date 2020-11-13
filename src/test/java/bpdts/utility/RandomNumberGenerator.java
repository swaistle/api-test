package bpdts.utility;

import java.util.Random;

public class RandomNumberGenerator {

    public static int randomNumber() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
