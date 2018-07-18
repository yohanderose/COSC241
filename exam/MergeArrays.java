import java.util.Arrays;
public class MergeArrays {

  public static void main(String[] args) {
    int[] a = {1,3,3,5};
    int[] b = {1,4};
    System.out.println(Arrays.toString(merge(a, b)));
  }

  public static int[] merge(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];
    int aIndex = 0;
    int bIndex = 0;
    int resultIndex = 0;
    while (resultIndex < result.length) {
      while (bIndex < b.length && aIndex < a.length) {
        if(a[aIndex] < b[bIndex]) {
          result[resultIndex] = a[aIndex];
          aIndex++;
        } else {
          result[resultIndex] = b[bIndex];
          bIndex++;
        }
        resultIndex++;
      }
      while (bIndex < b.length) {
        result[resultIndex] = b[bIndex];
        bIndex++;
        resultIndex++;
      }
      while (aIndex < a.length) {
       result[resultIndex] = a[aIndex];
       aIndex++;
       resultIndex++;
      }
    }

    return result;
  }
}
