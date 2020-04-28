package philosophers;

import java.util.Random;

public class SleepUtilities {
    private static Random random = new Random();

    static void nap() {
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
