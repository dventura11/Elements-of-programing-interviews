package main

import "fmt"

func main() {
	fmt.Println("vim-go")
}

type Node struct {
	v     int
	left  *Node
	right *Node
}

func isBalanced(root *Node) bool {
	balanced, max := isBalancedNode(root, -1)
}

func isBalancedNode(root *Node, level int) (bool, int) {
	if root == nil {
		return true, level + 1
	}

	bLeft, maxLeft := isBalancedNode(root.left, level)
	if !bLeft {
		return false, maxLeft + 1
	}

	bRight, maxRight := isBalancedNode(root.right, level)

	if !bRight {
		return false, maxRight + 1
	}

	if maxLeft > maxRight {
		temp = maxRight
		maxRight = maxLeft
		maxLeft = temp
	}

	isBalancedNode = (maxRight - maxLeft) < 2
	return isBalanced, maxRight
}
