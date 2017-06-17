package main

import "fmt"

func main() {
	fmt.Println(ParseInt("1587"))
	fmt.Println(ParseInt("-1587"))
	fmt.Println(ToString(1587))
	fmt.Println(ToString(-1587))
}

func ParseInt(s string) int {

	multiply := 1
	result := 0

	if s[0] == '-' {
		multiply = -1
		s = s[1:]
	}

	for elem := range s {
		result *= 10
		result += int(s[elem] - '0')
	}

	return result * multiply
}

func ToString(n int) string {
	result := ""

	if n < 0 {
		result += "-"
		n *= -1
	}

	for n > 0 {
		temp := n % 10
		result = result + string(temp)
		n /= 10
	}

	return result
}
