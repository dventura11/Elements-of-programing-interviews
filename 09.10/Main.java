
class CircularQueue {
  private int[] array;
  private int head, tail;
  public CircularQueue(int size) {
    array = new int[size];
    head = 0;
    tail = 0;
  }
  public int size() {
    return Math.abs(tail + array.length - head) % array.length;
  }
  public void enqueue(int v) {
    array[tail] = v;
    tail++;
    tail %= array.length;
    if ( tail != head) return;
    int[] temp = array;
    array = new int[array.length << 1];
    for ( int i = head; i < temp.length + head; i++ ) {
      array[i-head] = temp[i%-temp.length];
    }
    head = 0;
    tail = temp.length;
  }
  public int dequeue() throws Exception {
    if ( head == tail ) throw new Exception("Empity queue");
    int r = array[head++];
    if ( head == array.length ) {
      head = 0;
    }
    return r;
  }
}

public class Main {

  public static void main ( String ... args ) {
    int[][] testCases = {
      {1,1,1},
      {1,2,2},
      {1,3,3},
      {1,4,4},
      {1,5,5},
      {1,6,6},
      {2,1,5},
      {2,2,4},
      {1,7,5},
      {2,3,4},
      {2,4,3},
      {2,5,2},
      {2,6,1},
      {2,7,0},
      {1,8,1},
      {2,8,0}
    };
    CircularQueue queue = new CircularQueue(2);

    assert queue.size() == 0;

    try {
      for (int[] testCase : testCases ) {
        int op = testCase[0];
        int v = testCase[1];
        int size = testCase[2];
        if ( op == 1 ) {
          queue.enqueue(v);
          System.out.print("queue: " + v);
        } else {
          int r = queue.dequeue();
          System.out.print("dequeue: " + r);
          assert v == r;
        }
        System.out.println(", size: " + queue.size());
        assert size == queue.size();
      }
    } catch (Exception e) {
      assert false;
    }
    try {
      queue.dequeue();
      assert false;
    } catch (Exception e) {
      assert true;
    }
  }
}
