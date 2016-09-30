package main

import "fmt"

type Node struct {
	value int
	next  *Node
}

func main() {
	var rootA, rootB *Node
	valuesA := []int{2, 5, 7}
	valuesB := []int{3, 11}
	for _, val := range valuesA {
		rootA = insertNode(rootA, &Node{value: val})
	}
	for _, val := range valuesB {
		rootB = insertNode(rootB, &Node{value: val})
	}

	printList(rootA)
	printList(rootB)
	root := Merge(rootA, rootB)
	printList(root)
}

func Merge(rootA, rootB *Node) *Node {
	var root, tail *Node
	for rootA != nil && rootB != nil {

		if rootA.value < rootB.value {
			root, tail, rootA = insert(root, tail, rootA)
		} else {
			root, tail, rootB = insert(root, tail, rootB)
		}
	}
	if rootB == nil {
		root, tail, rootA = insert(root, tail, rootA)
	} else {
		root, tail, rootB = insert(root, tail, rootB)
	}

	return root
}

func insert(root, tail, current *Node) (*Node, *Node, *Node) {
	if current == nil {
		return root, tail, current
	}

	if root == nil {
		root = current
	} else {
		tail.next = current
	}

	tail = current
	current = current.next
	return root, tail, current
}

func insertNode(root, node *Node) *Node {
	if root == nil {
		root = node
		return node
	}

	temp := root
	for temp.next != nil {
		temp = temp.next
	}
	temp.next = node
	return root
}
func printList(root *Node) {
	for root != nil {
		fmt.Printf("%v, ", root.value)
		root = root.next
	}
	fmt.Println("")
}
