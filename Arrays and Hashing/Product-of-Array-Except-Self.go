/*
	238. Product of Array Except Self

	Given an integer array nums, return an array answer such that
	answer[i] is equal to the product of all the elements of nums except nums[i].

	Write an algorithm in linear time without using division!
*/

package main

import "fmt"

func main() {
	/*
			Each number in the result could be analyzed as a product of two groups of numbers ->
		from the left hand and the right hand side e.g. the number at the 2nd index results from
		the numbers at indices 0 and 1 (left hand side) and the numbers at indices 3 etc. (right hand side).
			Loop through the array and put the "left-hand" multiplicands in each slot.
		For the slot put 1 since it has no "generating elements"
			Loop again, this time backwards, put the "right-hand" multiplicands.
		Similarly, put 1 for the rightmost slot.
	*/

	var nums = [...]int{1, 2, 3, 4}
	//expected {24,12,8,6}

	var result [len(nums)]int
	var mult = 1
	for i, num := range nums {
		result[i] = mult
		mult *= num
	}

	mult = 1
	for j := len(nums) - 1; j >= 0; j-- {
		result[j] *= mult
		mult *= nums[j]
	}

	fmt.Print(result)
}
