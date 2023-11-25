import java.util.Random;

interface AccountInterface {
    Random random = new Random();
    final int accdId = random.nextInt(1000);
}
