package main

import "fmt"

func main() {
	testCases := [][]float32{
		{2.0, 2.0},
		{2.0, 5.0},
		{2.0, 12.0},
		{2.0, 21.0},
		{2.0, 13.0},
	}

	for _, v := range testCases {
		fmt.Printf("%v^%v = %v \n", v[0], v[1], Power(v[0], int(v[1])))
	}
	for i := 0; i < 20; i++ {
		fmt.Printf("%v^%v = %v \n", 2, i, Power(2.0, i))
	}
}

func Power(x float32, y int) float32 {
	switch y {
	case 0:
		return 1.0
	case 1:
		return x
	default:
		result := x
		p := 1
		for p<<1 <= y {
			result *= result
			p <<= 1
		}
		y -= p
		return result * Power(x, y)
	}
}
