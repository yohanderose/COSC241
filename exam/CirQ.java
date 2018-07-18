import java.util.Arrays;
public class CirQ {

  public int tail, head;
  public int[] q = new int[4];

  public CirQ() {
    this.head = 0;
    this.tail = 0;
  };

  public void enque(int n) {
    if (this.head == this.tail) {
      q[this.tail] = n;
      tail++;
    } else if (this.tail%10 + 1 != this.head) {
      q[this.tail%10 +1] = n;
      tail++;
    }
  }
  public int deque() {
    head++;
    return q[head-1];
  }

  public static void main(String[] args) {
    CirQ c = new CirQ();
    c.enque(1);
    System.out.println(Arrays.toString(c.q));
    c.enque(2);
    System.out.println(Arrays.toString(c.q));
    c.enque(3);
    System.out.println(Arrays.toString(c.q));
    c.enque(4);


    System.out.println(Arrays.toString(c.q));
  }
}
