#include <iostream>

using namespace std;

struct Node {
    int value;
    Node * next;
};

Node * merge(Node * left, Node * right) {

    // Create a ficticious root node
    Node * root = new Node;
    Node * root2 = root;

    while (left && right) {
        if (left->value < right->value) {
            root->next = left;
            left = left->next;
        } else {
            root->next = right;
            right = right->next;
        }
        root = root->next;
    }

    // one of the 2 has ended
    if (left != nullptr)
        root->next = left;
    else if (right != nullptr)
        root->next = right;


    return root2->next;
}


int main() {

    int i = 0;
    Node * left = new Node;
    Node * leftRoot = left;

    while (i++ < 5) {
        left->value = i;
        left->next = new Node;
        left = left->next;
    }

    left->next = nullptr;


    Node * right = new Node;
    Node * rightRoot = right;

    i = 0;
    while (i++ < 10) {
        right->value = i;
        right->next = new Node;
        right = right->next;
    }

    right->next = nullptr;

    Node * result = merge(leftRoot, rightRoot);

    while (result != nullptr) {
        cout << "[ " << result->value << "], " ;
        result = result->next;
    }
    cout << endl;

    cout << "Done" << endl;

}
