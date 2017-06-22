
class ListNode {
  int value;
  ListNode next;
  public ListNode(int v){
    value = v;
  }
  public ListNode(int ... values){
    if ( values.length == 0 ) return;
    this.value = values[0];
    ListNode current = this;
    for (int i = 1; i < values.length; i++) {
      current.next = new ListNode(values[i]);
      current = current.next;
    }
  }
  public String toString() {
    StringBuilder sb = new StringBuilder("<");
    for ( ListNode current = this; current != null; current = current.next)
      sb.append(current.value + ( current.next == null ? "" : " ,"));
    sb.append(">");
    return sb.toString();
  }
}

public class Main {

  public static void main(String ... args) {
    ListNode[] out = new ListNode[] {
      new ListNode(1,2,3,4,5,6,7,8,9),
          new ListNode(1,2,3,4,5,6,7,8,10),
          new ListNode(1,2,3,4,5,6,7,9,10),
          new ListNode(1,2,3,4,5,6,8,9,10),
          new ListNode(1,2,3,4,5,7,8,9,10),
          new ListNode(1,2,3,4,6,7,8,9,10),
          new ListNode(1,2,3,5,6,7,8,9,10),
          new ListNode(1,2,4,5,6,7,8,9,10),
          new ListNode(1,3,4,5,6,7,8,9,10),
          new ListNode(2,3,4,5,6,7,8,9,10)
    };
    for (int i = 0; i < 10; i ++) {
      ListNode current = null, list = new ListNode(1,2,3,4,5,6,7,8,9,10);
      list = removeKLatest(i + 1, list);
      System.out.print("result: " + list + ", expected: " + out[i] + " = " );
      for (current = out[i]; current != null; current = current.next) {
        if ( list.value != current.value) {
          System.out.print("(" + list.value + " != " + current.value + ")");
          break;
        }
        list = list.next;
      }
      System.out.println( list == null && current == null) ;
    }
  }

  public static ListNode removeKLatest(int k, ListNode l) {
    int size = 0;
    for ( ListNode current = l; current != null; current = current.next) size++;
    if ( k == size) return l.next;
    size -= k;
    for ( ListNode current = l; current != null; current = current.next) {
      if ( --size == 0 ) {
        current.next = current.next.next;
        break;
      }
    }
    return l;
  }
}
