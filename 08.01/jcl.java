public class MergeList {

    public static void  main (String[] args){
        List L = new List();
        List F = new List();
        L.addNode(2);
        L.addNode(5);
        L.addNode(7);
        F.addNode(3);
        F.addNode(11);
        List list = mergeLists(L, F);
        System.out.println("Done");
    }

    static List mergeLists(List a, List b){
        if (a.root.value < b.root.value) { // Choose smallest list
            mergeNodes(a.root, b.root);
            return a;
        }
        else {
            mergeNodes(b.root, a.root);
            return b;
        }
    }

    static void mergeNodes(Node before, Node after){
        if (before.next != null)
            mergeNodes(before.next, after);
        else if(after.next != null)
            mergeNodes(before, after.next);
        if (before.value < after.value)
            before.next = after;
        else
            after.next = before;
    }

}

class List {

    Node root;

    public void addNode(int v){
        if (this.root == null)
            root = new Node(v);
        else {
            Node t = root;
            while (t.next != null)
                t = t.next;
            t.next = new Node(v);
        }
    }
}

class Node {

    Node next;
    int value;

    public Node(int v) {
        value = v;
    }

    public Node(int v, Node next) {
        this.next = next;
        value = v;
    }

}