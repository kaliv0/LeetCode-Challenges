/*
179. Largest Number

Given a list of non-negative integers nums,
arrange them such that they form the largest number and return it.

Since the result may be very large,
so you need to return a string instead of an integer.
*/

package main

import (
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	var nums = []int{3, 30, 34, 5, 9}
	//convert int numbers to strings
	var sNums = make([]string, len(nums))
	for i, x := range nums {
		sNums[i] = strconv.Itoa(x)
	}

	//sort array by checking which concatenated strings form larger result
	sort.Slice(sNums, func(i int, j int) bool {
		return sNums[i]+sNums[j] > sNums[j]+sNums[i]
	})

	//edge case if array contains zeros
	if sNums[0] == "0" {
		fmt.Print("0")
		os.Exit(0)
	}

	fmt.Print(strings.Join(sNums, ""))
}
