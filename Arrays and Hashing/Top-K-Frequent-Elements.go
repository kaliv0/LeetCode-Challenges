/*
	347. Top K Frequent Elements

	Given an integer array nums and an integer k, return the k most frequent elements.
	You may return the answer in any order.
*/

package main

import (
	"fmt"
	"sort"
)

func main() {
	/*
		loop through array and keep count of equal numbers in a map
		sort map's values in descending order and return top k elements
	*/

	var nums = [...]int{1, 1, 1, 2, 2, 3}
	var k = 2
	//var nums = [...]int{1}
	//var k = 1

	var counter = make(map[int]int)
	for _, n := range nums {
		counter[n]++
	}

	//read values from map
	var values []int
	for _, v := range counter {
		values = append(values, v)
	}

	//and sort them
	sort.Ints(values)

	var result = values[0:k]
	fmt.Println(result)

}
