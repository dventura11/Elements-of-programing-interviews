
public class Main {
  private static String format(int[] data) {
    StringBuilder result = new StringBuilder("[");
    for(int v : data) result.append(v + ", ");
    if (data.length > 0) result.delete(result.length() - 2, result.length());
    result.append("]");
    return result.toString();
  }
  public static void main (String[] args) {
    int[][] data = {
      {1,2,3,4,5,6},
      {7,8,9},
      {1,2,3},
      {4},
      {},
      {5,6,7,8}
    };
    String[] expected = {
      "[1, 2, 3, 4, 5, 6]",
      "[7, 8, 9]",
      "[1, 2, 3]",
      "[4]",
      "[]",
      "[5, 6, 7, 8]"
    };

    CustomIterator it = new CustomIterator(data);
    for(int i = 0; it.hasMore(); i++) {
      String listString = format(it.next());
      System.out.println(expected[i] + " = " + listString + " -> " + (listString.equals(expected[i])) );
    }
    System.out.println("hasMore = " + it.hasMore() +" -> "+ (it.hasMore() == false));
    System.out.print("next == IndexOutOfBoundsException? -> ");
    try {
      it.next();
      System.out.println(false);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(true);
    }

    it = new CustomIterator(data);
    it.remove();
    for(int i = 1; it.hasMore(); i++) {
      String listString = format(it.next());
      System.out.println(expected[i] + " = " + listString + " -> " + (listString.equals(expected[i])) );
    }
    System.out.println("hasMore = " + it.hasMore() +" -> "+ (it.hasMore() == false));
    System.out.print("next == IndexOutOfBoundsException? -> ");
    try {
      it.next();
      System.out.println(false);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(true);
    }

  }
}
class CustomIterator {

  private int index;
  private int[][] matrix;

  public CustomIterator(int[][] matrix) {
    index = 0;
    this.matrix = matrix;
  }
  public boolean hasMore() {
    return index < matrix.length;
  }
  public int[] next() {
    if ( hasMore() ) {
      return matrix[index++];
    }
    throw new IndexOutOfBoundsException();
  }
  public void remove() {
    if ( !hasMore() ) {
      return;
    }
    int[][] temp = matrix;
    matrix = new int[matrix.length-1][];
    int writeIndex = 0;
    for ( int i = 0; i < temp.length; i++ ) {
      if ( i == index ) continue;
      matrix[writeIndex++] = temp[i];
    }
  }
}
