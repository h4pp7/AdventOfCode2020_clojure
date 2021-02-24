(ns advent-of-code.day-07
  "AOC 2020 Day 7"
  (:require [advent-of-code.util :refer [split-lines]]))

(defn part-1
  "Day 07 Part 1"
  [input]
  input)

(defn part-2
  "Day 07 Part 2"
  [input]
  input)

(defn parse-line
  [line]
  [(re-find #"^\w*\s\w*(?=\sbag)" line)
   (for [b (re-seq #"(\d)\s(\D*\s\D*(?=\sbag))" line)]
     [(nth b 2)
      (read-string (nth b 1))])])  

(defn add-node
  [graph node-key]
  (cond (contains? graph node-key) graph
        :else (assoc graph node-key nil)))

(defn add-edge
  [graph source-key target-key value]
  (assoc
    (add-node graph target-key)
    source-key
    (assoc (get graph source-key) 
           target-key value)))
