import java.util.ArrayList;
public class QueueOut {
  public static void main(String[] args) {
    ArrayList<Integer> q = new ArrayList<>();
    q.add(3);
    while (!q.isEmpty()) {
      int i = q.remove(0);
      System.out.println(i);
      for (int k = 0; k< i; k++) {
        q.add(k);
      }
    }
  }

}
