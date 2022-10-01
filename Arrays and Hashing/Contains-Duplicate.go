/*
217.Contains Duplicate

Given an integer array nums, return true
if any value appears at least twice in the array,
and return false if every element is distinct.
*/

package main

import "fmt"

func main() {

	//var arr1 = [...]int{1, 2, 3, 1}
	//var arr2 = [...]int{1, 2, 3, 4}
	var arr3 = [...]int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}

	//loop through the given array and put each new number in a set
	//check if the set already contains the number - if through break out of the loop and return True

	//One reason  Go doesn't support sets as data structures is that it is easy to create a set from map
	var flag = false
	var nums = make(map[int]bool)

	for _, val := range arr3 {
		_, ok := nums[val]
		if ok {
			flag = true
			break
		}
		nums[val] = true
	}

	fmt.Println(flag)
}
