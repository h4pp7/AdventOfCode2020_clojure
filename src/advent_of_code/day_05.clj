(ns advent-of-code.day-05
  "AOC 2020 Day 5"
  (:require [advent-of-code.util :refer [split-lines]]))

(defn parse-seatnum
  [s]
  (-> s
       (clojure.string/replace #"B|R" "1") 
       (clojure.string/replace #"F|L" "0") 
       (#(str "2r" %))
       (read-string)))
       
(defn part-1
  "Day 05 Part 1"
  [input]
  (->> input
       (split-lines)
       (map #(parse-seatnum %))
       (apply max)))

(defn part-2
  "Day 05 Part 2"
  [input]
  (let [tickets (->> input
                     (split-lines)  
                     (map #(parse-seatnum %)))
        min-seat (apply min tickets)
        max-seat (apply max tickets)]
    (- (reduce + (range min-seat (inc max-seat))) 
       (reduce + tickets)))) 
