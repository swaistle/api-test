package bpdts.pages;

import java.util.Random;

public class RandomNumberGenerator {

    public static int randomNumber() {
        Random r = new Random();

        int low = 1;
        int high = 1000;
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
