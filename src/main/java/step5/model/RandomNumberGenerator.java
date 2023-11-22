package step5.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAXIMUM_RANDOM_NUMBER = 10;

    @Override
    public int generate() {
        return new Random().nextInt(MAXIMUM_RANDOM_NUMBER);
    }
}
