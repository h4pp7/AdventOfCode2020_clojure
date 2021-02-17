(ns advent-of-code.day-03
  "AOC 2020 Day 3"
  (:require [advent-of-code.util :refer [split-lines]]))

; TODO do it with map instead of a loop?

(defn traverse
  [treemap start slope obstacle]
  (loop [x start
         y 0
         hits 0]
    (if (> y (- (count treemap) 1))
      hits
      (recur (mod (+ x (slope 0)) (count (treemap y)))
             (+ y (slope 1))
             (+ hits (if (= (nth (treemap y) x) obstacle) 1 0))))))

(defn part-1
  "Day 03 Part 1"
  [input]
  (traverse (split-lines input) 0 [3 1] \#))

(defn part-2
  "Day 03 Part 2"
  [input]
  (let [slopes [[1 1] [3 1] [5 1] [7 1] [1 2]]
        treemap (split-lines input)]
    (reduce * (map #(traverse treemap 0 % \#) slopes))))
