package observer;
import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();   // 난수발생기
    private int number;                        // 현재의 수
    public int getNumber() {                   // 수를 취득한다
        return number;
    }
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();           
        }
    }
}
