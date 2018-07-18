import java.util.Random;

public class Randy {

    public static void main(String[] args) {
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.print(r.nextInt(2) + " ");
        }
    }
}
    
