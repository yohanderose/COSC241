import java.math.*;
public class BigOh {
  public static int counter = 0;
  public static int n = 1000;

  public static void main(String[] args) {



    System.out.println("Calls: " + counter);
    System.out.println("Compare: " + (Math.log(n)/Math.log(2)));
  }
    
}
