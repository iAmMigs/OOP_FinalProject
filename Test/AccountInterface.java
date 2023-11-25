import java.util.Random;

interface AccountInterface {
    Random random = new Random();
    final int recordId = random.nextInt(1000);
}
