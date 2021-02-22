# Advent of Code 2020 in Clojure

My solutions for [Advent of Code](https://www.adventofcode.com) 2020 using Clojure.
Template copied from [Advent of Code Clojure Starter](https://github.com/mhanberg/advent-of-code-clojure-starter).

## Notes
### Day 1
Solved without Combinatorics, just simple list comprehension. 

### Day 2
You can check whether a value lies in a range with

```clojure
(<= start value end)
```

### Day 3
Made two version, one with a loop the other with mapping and filtering over the
rows. The recursive loop is way faster than the non-loop version.

### Day 4
Instead of doing the validation of the fields all with regex like in [my Julia
solution](https://git.sr.ht/~happy/AdventOfCode2020.jl/tree/main/item/src/Day04.jl),
I used this puzzle to learn how to construct maps. Part 1 is just checking
whether a key exists. Part 2 uses helper predicate functions for the fields.
`Cond` and `Condp` is used to check the fields and stop on the first invalid
field. Not 100% sure `cond` is more appropriate here than `case`.

### Day 5
Parse seat numbers by replacing "B" and "R" with "1" and "F" and "L" with "0".
Then parse the string to number. For part 2, subtract the sum of all the seat
numbers from the sum of all numbers from the minimum seat number to the maximum
seat number.

## Usage
### Writing the solutions
There are 25 namespaces, 25 input files 25 example input files, 25 tests, and
50 `lein` tasks. 

1. Fill in the tests with the example solutions.
1. Write your implementation.
1. Fill in the final problem inputs into the `lein` task and run `lein run d01.p1`!

```clojure
(ns advent-of-code.day-01)

(defn part-1
  "Day 01 Part 1"
  [input]
  input)

(defn part-2
  "Day 01 Part 2"
  [input]
  input)
```

```clojure
(ns advent-of-code.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-01 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected nil]
    (is (= expected (part-1 (slurp (resource "day-1-example.txt")))))))

(deftest part2
  (let [expected nil]
    (is (= expected (part-2 (slurp (resource "day-1-example.txt")))))))
```

### Run
Run the tests with `lein test`. You can run tests for a specific day only with `lein test :only /path/to/day_XX_test.clj`.

Run the parts with `lein run dXX.pX`.
