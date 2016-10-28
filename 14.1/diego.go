package main

import "fmt"

func main() {
	a := []int{1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 9, 11, 12, 33, 44}
	b := []int{3, 3, 5, 7, 8, 13, 33}
	intersected := intersection(a, b)
	fmt.Println(intersected)
}

func intersection(a, b []int) []int {
	c := make([]int, 0)
	ia, ib := 0, 0
	for ia < len(a) && ib < len(b) {
		if a[ia] == b[ib] {
			c = append(c, a[ia])
			ia = move(ia, a)
			ib = move(ib, b)
			continue
		}
		if a[ia] < b[ib] {
			ia = move(ia, a)
			continue
		}
		ib = move(ib, b)
	}
	return c
}

func move(i int, arr []int) int {
	for i++; i < len(arr); i++ {
		if i > len(arr) || arr[i] != arr[i-1] {
			break
		}
	}
	return i
}
