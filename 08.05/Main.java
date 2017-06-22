
class ListNode {
  int value;
  ListNode next;
  public ListNode(int v) {
    value = v;
  }
  public ListNode(int ... values) {
    this.value = -1;
    ListNode current = null;
    for (int v : values) {
      if ( this.value == -1) {
        this.value = v;
        current = this;
        continue;
      }
      current.next = new ListNode(v);
      current = current.next;
    }
  }

  public ListNode add(ListNode l) {
    ListNode current = this;
    while ( current.next != null) current = current.next;
    current.next = l;
    return this;
  }

  public String toString() {
    String s = "<";
    for (ListNode current = this;  current != null; current = current.next) {
      s += current.value + (current.next == null ? "" :  ",");
    }
    s += ">";
    return s;
  }

}

public class Main {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1,2,3,4,5,6,7,8,9,10);
    ListNode l2 = new ListNode(11,12,13,14,15,16,17,18,19,20);
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == false) );

    l1 = new ListNode(1,2,3,4,5,6,7,8,9,10);
    l2 = null;
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == false) );

    l1 = null;
    l2 = new ListNode(1,2,3,4,5,6,7,8,9,10);
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == false) );

    l1 = new ListNode(5,6,7,8,9,10);
    l2 = l1;
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == true) );

    l1 = new ListNode(5,6,7,8,9,10);
    l2 = new ListNode(1,2,3,4);
    l2.add(l1);
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == true) );

    l1 = new ListNode(5,6,7,8,9,10);
    l2 = new ListNode(1,2,3,4);
    l1.add(l2);
    System.out.println(l1 + ", " + l2 + " = " + (isOverLaping(l1,l2) == true) );

  }

  public static boolean isOverLaping(ListNode l1, ListNode l2) {
    if ( l1 == null || l2 == null ) return false;
    int size, sizeL1 = 0, sizeL2 = 0;
    ListNode c1 = l1;
    ListNode c2 = l2;
    while ( c1 != null || c2 != null) {
      if ( c1 != null) {
        c1 = c1.next;
        sizeL1++;
      }
      if ( c2 != null) {
        c2 = c2.next;
        sizeL2++;
      }
    }
    if ( sizeL1 > sizeL2) {
      for (int i = 0; i < sizeL1 - sizeL2; i++) l1 = l1.next;
      size = sizeL2;
    } else {
      for (int i = 0; i < sizeL2 - sizeL1; i++) l2 = l2.next;
      size = sizeL1;
    }
    for (int i = 0; i < size; i++) {
      if ( l1 == l2) return true;
      l1 = l1.next;
      l2 = l2.next;
    }
    return false;
  }

}

