public class PatternWordRecursion {
  public static int containsCounter = 0;
  public static void main(String[] args) {

    System.out.println(contains("bacbaac", "abc"));
    System.out.println("calls: " + containsCounter);
  }

  public static boolean contains(String text, String pattern) {
    containsCounter++;
    System.out.println("text: " + text + "\tpattern: " + pattern);
    if (pattern.length() == 0) {
      return true;
    }
    if (pattern.length() > text.length()) {
      return false;
    }
    int i = text.indexOf(pattern.charAt(0));
    System.out.println("i: " + i);
    if (i == -1) {
      return false;
    }

    return contains(text.substring(i+1), pattern.substring(1));

  }
}
