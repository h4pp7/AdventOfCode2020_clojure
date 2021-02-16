(ns advent-of-code.day-02
  "AOC 2020 Day 2"
  (:require [advent-of-code.util :refer [split-lines]]))

(defn parse-line
  [line]
  (let [n-matcher (re-matcher #"\d+" line)
        l-matcher (re-matcher #"[a-zA-Z]+" line)
        min-num (Integer/parseInt (re-find n-matcher))
        max-num (Integer/parseInt (re-find n-matcher))
        letter (re-find l-matcher)
        pw (re-find l-matcher)]
    [min-num max-num letter pw]))

(defn isvalid-p1 
  [[min-num max-num letter pw]]
  (<= min-num (count (re-seq (re-pattern letter) pw)) max-num))

(defn isvalid-p2 
  [[min-num max-num letter pw]]
  (let [l (first letter)
        c1 (nth pw (- min-num 1))
        c2 (nth pw (- max-num 1))]
    (and (or (= l c1) (= l c2)) (not (and (= l c1) (= l c2))))))

(defn part-1
  "Day 02 Part 1"
  [input]
  (->> input
       split-lines
       (map parse-line)
       (filter isvalid-p1)
       count))

(defn part-2
  "Day 02 Part 2"
  [input]
  (->> input
       split-lines
       (map parse-line)
       (filter isvalid-p2)
       count))
