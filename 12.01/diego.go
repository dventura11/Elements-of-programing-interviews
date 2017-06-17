package main

import "fmt"

func main() {
	data := []int{1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 6, 6, 6, 6, 7, 7, 8, 8, 9}
	for i := 0; i <= 10; i++ {
		minIndex, found := binarySearch(data, i)
		fmt.Printf("found %v? \t%v, \tminIndex: %v \tin  %v\n", i, found, minIndex, data)
	}
}

func binarySearch(arr []int, x int) (int, bool) {
	min := -1
	left := 0
	right := len(arr) - 1

	for left <= right {
		m := left + ((right - left) / 2)
		//fmt.Printf("searching %v vs %v in %v:[%v-%v], m=%v, min = %v \n", x, arr[m], arr[left:right+1], left, right, m, min)
		if x == arr[m] {
			min = m
			right = m - 1
			continue
		}
		if x < arr[m] {
			right = m - 1
		} else {
			left = m + 1
		}
	}

	return min, min >= 0
}
