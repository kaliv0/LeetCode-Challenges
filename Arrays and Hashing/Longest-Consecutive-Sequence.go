/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.
*/
package main

import (
	"fmt"
	"os"
	"sort"
)

func main() {
	//var nums = [...]int{1, 2, 0, 1}
	//var nums = [...]int{}
	//var nums = [...]int{100, 4, 200, 1, 3, 2}
	var nums = [...]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}

	if len(nums) == 0 {
		fmt.Print(0)
		os.Exit(0)
	}

	//sort numbers
	sort.Ints(nums[:])

	var maxSeq int
	var currSeq = 1
	for i := 0; i < len(nums)-1; i++ {
		//loop while numbers have consecutive values
		if nums[i+1] == nums[i]+1 {
			currSeq++
			continue
		}
		//clear duplicates
		if nums[i+1] == nums[i] {
			continue
		}

		//otherwise the sequence is over or hasn't started yet
		//check if the sequence was the longest one so far
		if currSeq > maxSeq {
			maxSeq = currSeq
		}
		//prepare for the beginning of a new sequence
		currSeq = 1
	}

	//in cases where the sequence includes the last number in the array
	if currSeq > maxSeq {
		maxSeq = currSeq
	}
	fmt.Print(maxSeq)
}
