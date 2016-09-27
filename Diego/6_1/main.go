package main

import "fmt"

func main() {
	for i := 0; i < 33; i++ {
		data := []int{4, 5, 6, 7, 8, 2, 7, 3, 5, 67, 8, 4, 3, -1, -1, -3, 2, -134, -123, -1, -43, 43, 2, 9, 11, 10, 12, 34, 56, 42, 1, 2, 4}
		val := data[i]
		fmt.Printf("%v.- %v: %v\n", i, val, DutchNationalFlag(data, i))
	}
}

func DutchNationalFlag(a []int, pivot int) []int {
	val := a[pivot]
	left, equal, right := 0, 0, len(a)
	for equal < right {
		if a[equal] < val {
			a[left], a[equal] = a[equal], a[left]
			left++
			equal++
		} else if a[equal] > val {
			right--
			a[equal], a[right] = a[right], a[equal]
		} else {
			equal++
		}
	}
	return a
}
