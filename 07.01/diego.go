package main

import "fmt"

func main() {
	fmt.Println(ParseInt("143"))
	fmt.Println(ParseInt("-143"))
	fmt.Println(ParseInt("0"))
	fmt.Println(ParseInt("14030"))
	fmt.Println(ToString(143))
	fmt.Println(ToString(-143))
	fmt.Println(ToString(0))
	fmt.Println(ToString(14030))
}

func ParseInt(s string) int {
	multiply := 1
	result := 0

	if s[0] == '-' {
		multiply = -1
		s = s[1:]
	}

	for _, elem := range s {
		result *= 10
		result += int(elem - '0')
	}

	return result * multiply
}

func ToString(n int) string {
	result := ""
	negative := false

	if n < 0 {
		negative = true
		n *= -1
	}
	//do while simulation in go
	for ok := true; ok; ok = (n > 0) {
		result = fmt.Sprint((n % 10), result)
		n /= 10
	}
	if negative {
		result = "-" + result
	}
	return result
}
