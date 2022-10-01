/*
1.Two Sum

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.
*/

package main

import (
	"fmt"
)

func main() {
	var nums = [...]int{2, 11, 7, 15}
	var target = 9
	//var nums = [...]int{3, 2, 4}
	//var target = 6
	//var nums = [...]int{3, 3}
	//var target = 6

	/*
		loop through array, store each number and its index in a map
		calculate complementary number and look for it in the map
		if found, return indices of both numbers
	*/

	var indices = make(map[int]int)
	var compNum int
	for indx, curr := range nums {
		compNum = target - curr
		compIndx, ok := indices[compNum]
		if ok {
			fmt.Println([...]int{compIndx, indx})
			break
		}
		indices[curr] = indx
	}
}
