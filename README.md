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
rows. Why is the loop much faster?

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
