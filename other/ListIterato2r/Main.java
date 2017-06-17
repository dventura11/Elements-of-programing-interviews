import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list.

// This iterator should provide three public class member functions:

// boolean hasNext()
//   Returns true if the iteration has more elements.

// int next()
//   Returns the next element in the iteration.

// void remove()
//   Removes the last element returned by this iterator.
//   i.e. Remove the element that the previous next() returned.

// [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]

class Solution {
  public static void main(String[] args) {
    List<List<Integer>> arrayList = Arrays.asList(
        Arrays.asList(),
        Arrays.asList(1,2,3),
        Arrays.asList(4,5),
        Arrays.asList(),
        Arrays.asList(),
        Arrays.asList(6),
        Arrays.asList(7,8),
        Arrays.asList(),
        Arrays.asList(9),
        Arrays.asList(10),
        Arrays.asList());

    MatrixIterator it = new MatrixIterator(arrayList);
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

class MatrixIterator {
  private List<List<Integer>> list;
  private int arrayIndex;
  private int elementIndex;

  public MatrixIterator(List<List<Integer>> list) {
    this.list = list;
    elementIndex = 0;
    for (arrayIndex = 0; arrayIndex < list.size(); arrayIndex++) {
      if (list.get(arrayIndex).size() > 0) {
        break;
      }
    }
  }

  public boolean hasNext() {
    if ( arrayIndex >= list.size()) {
      return false;
    }
    if ( elementIndex < list.get(arrayIndex).size()){
      return true;
    }
    for (int i = arrayIndex + 1; i < list.size(); i++) {
      if (list.get(i).size() > 0) {
        return true;
      }
    }
    return false;
  }

  public int next() {
    if ( arrayIndex >= list.size()) {
      throw new IndexOutOfBoundsException();
    }
    int next = list.get(arrayIndex).get(elementIndex);
    if (elementIndex + 1 < list.get(arrayIndex).size()) {
      elementIndex++;
      return next;
    }
    elementIndex = 0;
    for (arrayIndex++; arrayIndex < list.size(); arrayIndex++) {
      if (list.get(arrayIndex).size() > 0) {
        break;
      }
    }
    return next;
  }

  public void remove() {
    if ( arrayIndex >= list.size()) {
      throw new IndexOutOfBoundsException();
    }
    list.get(arrayIndex).remove(elementIndex);
    if ( elementIndex > 0 && list.get(arrayIndex).size() > 0) {
      elementIndex--;
    }

  }
}
