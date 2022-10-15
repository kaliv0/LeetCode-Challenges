/*
	49. Group anagrams

    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
*/

package main

import (
	"fmt"
	"sort"
)

func main() {
	//loop through given strings, put sorted string as key in dict and all anagrams as values
	var strs = [...]string{"eat", "tea", "tan", "ate", "nat", "bat"}

	var anagrams = make(map[string][]string)
	for _, word := range strs {
		var arr = []rune(word)
		sort.Slice(arr, func(i int, j int) bool { return arr[i] < arr[j] })
		var sortedStr = string(arr)
		anagrams[sortedStr] = append(anagrams[sortedStr], word)
	}

	//read values from map
	var values [][]string
	for _, v := range anagrams {
		values = append(values, v)
	}
	fmt.Print(values)
}
