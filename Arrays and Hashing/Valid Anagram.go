/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise
*/

package main

import (
	"fmt"
	"os"
	"sort"
)

type sortRunes []rune

func (s sortRunes) Less(i, j int) bool {
	return s[i] < s[j]
}

func (s sortRunes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s sortRunes) Len() int {
	return len(s)
}

func sortString(s string) string {
	r := []rune(s)
	sort.Sort(sortRunes(r))
	return string(r)
}

func main() {
	//simplest approach -> sort strings and check if they are equal
	var flag = false
	var s = "anagram"
	var t = "nagaram"
	//var s = "rat"
	//var t = "car"

	if len(s) != len(t) {
		fmt.Println(false)
		os.Exit(0)
	}
	sSorted := sortString(s)
	tSorted := sortString(t)
	if sSorted == tSorted {
		flag = true
	}

	fmt.Println(flag)

	//-------------------------------------------------------------------------------------------------//

	//other approach -> read first string and keep count of chars in a map
	//read second string and decrement char counts
	//check if all char counts equal zero

	/*
		var flag = true
		var s = "anagram"
		var t = "nagaram"
		//var s = "rat"
		//var t = "car"

		if len(s) != len(t) {
			fmt.Println(false)
			os.Exit(0)
		}

		var counter = make(map[rune]int)
		for _, val := range s {
			counter[val]++
		}

		for _, val := range t {
			counter[val]--
		}

		for _, val := range counter {
			if val != 0 {
				flag = false
				break
			}
		}

		fmt.Println(flag)
	*/
}
