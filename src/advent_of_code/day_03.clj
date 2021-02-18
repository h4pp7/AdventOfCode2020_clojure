(ns advent-of-code.day-03
  "AOC 2020 Day 3"
  (:require [advent-of-code.util :refer [split-lines]]))

(defn traverse
  [terrain start slope obstacle]
  (loop [x start
         y 0
         hits 0]
    (if (> y (- (count terrain) 1))
      hits
      (recur (mod (+ x (slope 0)) (count (terrain y)))
             (+ y (slope 1))
             (+ hits (if (= (nth (terrain y) x) obstacle) 1 0))))))

(comment 
  this non-loop version runs much slower than the loop
(defn step-right
  [row distance start]
  (nth (row 1)
       (+ start 
          (mod (* distance (row 0))
               (count (row 1))))))

(defn traverse
  [terrain start slope obstacle]
  (let [right (slope 0)
        down (slope 1)
        rows (map vector (range) (take-nth down terrain))]
    (->> rows
         (map #(step-right % right start))
         (filter #(= obstacle %))
         (count))))
)

(defn part-1
  "Day 03 Part 1"
  [input]
  (traverse (split-lines input) 0 [3 1] \#))

(defn part-2
  "Day 03 Part 2"
  [input]
  (let [slopes [[1 1] [3 1] [5 1] [7 1] [1 2]]
        terrain (split-lines input)]
    (reduce * (map #(traverse terrain 0 % \#) slopes))))
