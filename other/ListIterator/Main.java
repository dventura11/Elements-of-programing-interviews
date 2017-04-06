import java.util.ArrayList;
import java.util.List;

public class Main {
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
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for (int[] testCase : data) {
      List<Integer> temp =new ArrayList<Integer>();
      for (int val : testCase) {
        temp.add(val);
      }
      list.add(temp);
    }
    CustomIterator it = new CustomIterator(list);
    for(int i = 0; it.hasMore(); i++) {
      String listString = it.next().toString();
      System.out.println(expected[i] + " = " + listString + " -> " + (listString.equals(expected[i])) );
    }
    System.out.println("hasMore = " + it.hasMore() +" -> "+ (it.hasMore() == false));
    System.out.println("next == null? -> "+ (it.next() == null));

    it = new CustomIterator(list);
    it.remove();
    for(int i = 1; it.hasMore(); i++) {
      String listString = it.next().toString();
      System.out.println(expected[i] + " = " + listString + " -> " + (listString.equals(expected[i])) );
    }
    System.out.println("hasMore = " + it.hasMore() +" -> "+ (it.hasMore() == false));
    System.out.println("next == null? -> "+ (it.next() == null));


  }
}
class CustomIterator {

  private int index;
  private List<List<Integer>>  list;

  public CustomIterator(List<List<Integer>> list) {
    index = 0;
    this.list = list;
  }
  public boolean hasMore() {
    return index < list.size();
  }
  public List<Integer> next() {
    return hasMore() ? list.get(index++) : null;
  }
  public void remove() {
    list.remove(index);
    if ( index == list.size() ) {
      index--;
    }
  }
}
