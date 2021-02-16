(ns advent-of-code.day-01
  "AOC 2020 Day 1"
  (:require [advent-of-code.util :refer [split-lines]]))

(defn parse-input
  "parses the input into a vector of ints"
  [input]
  (->> input
       split-lines
       (map #(Integer/parseInt %))))

(defn part-1
  "Day 01 Part 1"
  [input]
  (let [data (parse-input input)]
    (first
      (for [a data, b data
            :when (= 2020 (+ a b))]
        (* a b)))))

(defn part-2
  "Day 01 Part 2"
  [input]
  (let [data (parse-input input)]
    (first
      (for [a data, b data, c data
            :when (= 2020 (+ a b c))]
        (* a b c)))))
