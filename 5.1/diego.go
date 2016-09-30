package main

import "fmt"

func main() {
	result := textParity([]uint64{1, 2, 3, 4, 11, 23, 44, 56, 1234567})
	fmt.Printf("text parity:%v\n ", result)
}

func textParity(text []uint64) byte {
	var result uint64
	result = 0
	for word := range text {
		result ^= (bitsNumber(uint64(word)) & 1)
	}
	return byte(result)
}

func bitsNumber(v uint64) uint64 {
	fmt.Println(v)
	v = v&0x5555555555555555 + (v>>1)&0x5555555555555555
	v = v&0x3333333333333333 + (v>>1)&0x3333333333333333
	v = v&0x0f0f0f0f0f0f0f0f + (v>>1)&0x0f0f0f0f0f0f0f0f
	v = v&0x00ff00ff00ff00ff + (v>>1)&0x00ff00ff00ff00ff
	v = v&0x0000ffff0000ffff + (v>>1)&0x0000ffff0000ffff
	v = v&0x00000000ffffffff + (v>>1)&0x00000000ffffffff
	return v
}
