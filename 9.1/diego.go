package main

import "fmt"

func main() {
	stack := NewStack()
	stack.push(1)
	printValues(stack)
	stack.push(1)
	printValues(stack)
	stack.push(5)
	printValues(stack)
	stack.push(1)
	printValues(stack)
	stack.push(3)
	printValues(stack)
	stack.push(7)
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.push(8)
	printValues(stack)
	stack.push(7)
	printValues(stack)
	stack.pop()
	printValues(stack)
	stack.pop()
	printValues(stack)
}

type Stack struct {
	stack    []int
	top      int
	maxStack []int
	maxTop   int
}

func NewStack() *Stack {
	return &Stack{
		stack:    make([]int, 0, 1024),
		maxStack: make([]int, 0, 1024),
	}
}

func (s *Stack) push(v int) {
	s.stack = append(s.stack, v)
	if len(s.maxStack) == 0 || v > s.stack[s.maxStack[len(s.maxStack)-1]] {
		s.maxStack = append(s.maxStack, len(s.stack)-1)
	}
}

func (s *Stack) pop() int {
	popValue := s.stack[len(s.stack)-1]
	if len(s.stack)-1 == s.maxStack[len(s.maxStack)-1] {
		s.maxStack = s.maxStack[:len(s.maxStack)-1]
	}
	s.stack = s.stack[:len(s.stack)-1]
	return popValue
}

func (s *Stack) peek() int {
	return s.stack[len(s.stack)-1]
}
func (s *Stack) max() int {
	return s.stack[s.maxStack[len(s.maxStack)-1]]
}

func printValues(s *Stack) {
	fmt.Printf("max value %v \tin stack: %v\n", s.max(), s.stack)
}
