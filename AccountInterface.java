import java.util.Random;

interface AccountInterface {
    Random random = new Random();
    final int accId = random.nextInt(1000);
}
