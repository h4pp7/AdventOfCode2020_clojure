(ns advent-of-code.day-08
  "AOC 2020 Day 8"
  (:require [advent-of-code.util :refer [split-lines]]
            [clojure.string :refer [split]]))

(defn parse-instruction
  [instruction]
  (let [i (split instruction #" ")]
    [(symbol (first i)) (read-string (last i))]))  

(defn acc [state value]
  {:ACC (+ (:ACC state) value) :PC (inc (:PC state))})
      
(defn step
  [state instr]
  ()) 

(defn part-1
  "Day 08 Part 1"
  [input]
  input)

(defn part-2
  "Day 08 Part 2"
  [input]
  input)
