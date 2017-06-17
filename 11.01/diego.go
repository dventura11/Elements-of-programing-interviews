package main

import (
	"container/heap"
	"fmt"
)

func main() {
	merged := merge([]int{1, 2, 8}, []int{1, 2, 3, 3, 4, 5}, []int{1, 3, 7, 8, 9})
	fmt.Println(merged)
}

func merge(data ...[]int) []int {
	minHeap := &IntHeap{}
	heap.Init(minHeap)
	for _, temp := range data {
		for _, v := range temp {
			heap.Push(minHeap, v)
		}
	}
	merged := make([]int, minHeap.Len())
	for i := range merged {
		merged[i] = heap.Pop(minHeap).(int)
	}
	return merged
}

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
