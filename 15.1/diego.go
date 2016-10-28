package main

import "fmt"

type Node struct {
	value int
	left  Node
	right Node
}

var last = MinInt

func main() {
	fmt.Println("vim-go")
}

func inOrder(root Node) bool {
	if root == nil {
		return true
	}

	if !inOrder(root.left) {
		return false
	}

	if root.value < last {
		return false
	}

	last = root.value

	return inOrder(root.right)
}
