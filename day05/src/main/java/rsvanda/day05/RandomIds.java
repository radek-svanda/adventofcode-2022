package rsvanda.day05;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomIds {

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        String random = new BigInteger(130, RandomIds.random).toString(32);
        System.out.println("Random " + random);
        String cut = random.substring(0, 16);
        System.out.println("Cut    " + cut);
    }

}
