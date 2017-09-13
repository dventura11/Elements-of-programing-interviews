import java.util.LinkedList;
import java.util.Queue;

class NodeTree {
  int data;
  NodeTree left, right;
  public NodeTree(int data) {
    this.data = data;
  }
}
public class Main {

  public static void main (String ... args) {
    NodeTree[] in = {
      generateTree(),
      generateTree(1,2,2,3,4,4,3),
      generateTree(1,2,2,3,4,4,3,5,6,7,8,8,7,6,5),
      generateTree(1,2,2,3,null,null,3,5,null,null,5,7,null,null,7),
      generateTree(1,2,2,3,null,null,3,5,null,7,null,null,7,null,5),
      generateTree(1,2,3,4,null,null,5,6,null,null,7)
    };
    boolean[] out = {
      true,
      true,
      true,
      true,
      false,
      false
    };
    for ( int i = 0; i < in.length; i++ ) {
      boolean r = isSymetric(in[i]);
      System.out.printf("test: %d, expected: %b, result: %b => %b\n",
          i, out[i], r, (out[i] == r));
    }
  }

  public static boolean isSymetric(NodeTree root) {
    return areSymetric(root, root);
  }
  private static boolean areSymetric(NodeTree root1, NodeTree root2) {
    if ( root1 == null && root2 == null) return true;
    //System.out.println( ( root1 == null ? null : root1.data) + " vs " + (root2 == null ? null : root2.data) );
    if ( root1 == null || root2 == null) return false;
    if ( root1.data != root2.data ) return false;
    return areSymetric(root1.left , root2.right) && areSymetric( root1.right, root2.left);
  }

  public static NodeTree generateTree(Integer ... v) {
    if ( v.length == 0 ) return null;
    NodeTree root = new NodeTree(v[0]);
    Queue<NodeTree> queue = new LinkedList<NodeTree>();
    queue.offer(root);
    int i = 0;
    while ( i < v.length - 1 && !queue.isEmpty() ) {
      NodeTree current = queue.poll();
      if (v[++i] != null) {
        current.left = new NodeTree(v[i]);
        queue.offer(current.left);
      }
      if (v[++i] != null) {
        current.right = new NodeTree(v[i]);
        queue.offer(current.right);
      }
    }
    return root;
  }
}
