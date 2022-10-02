/*
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:
- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/
package main

import "fmt"

type Coordinates struct {
	X int
	Y int
}

func main() {
	var board = [][]string{
		{"5", "3", ".", ".", "7", ".", ".", ".", "."},
		{"6", ".", ".", "1", "9", "5", ".", ".", "."},
		{".", "9", "8", ".", ".", ".", ".", "6", "."},
		{"8", ".", ".", ".", "6", ".", ".", ".", "3"},
		{"4", ".", ".", "8", ".", "3", ".", ".", "1"},
		{"7", ".", ".", ".", "2", ".", ".", ".", "6"},
		{".", "6", ".", ".", ".", ".", "2", "8", "."},
		{".", ".", ".", "4", "1", "9", ".", ".", "5"},
		{".", ".", ".", ".", "8", ".", ".", "7", "9"},
	}
	/*
		loop through matrix, keep track of all rows, columns and quadrants using maps,
		check if current number is already contained in one of the maps,
		if true -> sudoku board is invalid,
		otherwise put current number in maps
	*/
	var rows = make(map[int]map[string]bool)
	var columns = make(map[int]map[string]bool)
	var quadrants = make(map[Coordinates]map[string]bool)

	for rowIndx, row := range board {
		for colIndx, str := range row {
			if str == "." {
				continue
			}

			_, ok := rows[rowIndx][str]
			if ok {
				fmt.Print(false)
				return
			}
			//initialize the inner map
			if rows[rowIndx] == nil {
				rows[rowIndx] = make(map[string]bool)
			}
			//add number
			rows[rowIndx][str] = true

			_, ok = columns[colIndx][str]
			if ok {
				fmt.Print(false)
				return
			}
			if columns[colIndx] == nil {
				columns[colIndx] = make(map[string]bool)
			}
			columns[colIndx][str] = true

			//simplify the coordinate using floor division by 3
			//in this case round-towards-zero division
			quadrIndx := Coordinates{X: rowIndx / 3, Y: colIndx / 3}
			_, ok = quadrants[quadrIndx][str]
			if ok {
				fmt.Print(false)
				return
			}
			if quadrants[quadrIndx] == nil {
				quadrants[quadrIndx] = make(map[string]bool)
			}
			quadrants[quadrIndx][str] = true
		}
	}
	fmt.Print(true)
}
