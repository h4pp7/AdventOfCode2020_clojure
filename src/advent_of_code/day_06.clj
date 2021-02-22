(ns advent-of-code.day-06
  "AOC 2020 Day 6"
  (:require [advent-of-code.util :refer [split-lines split-p]]
            [clojure.string :as string]
            [clojure.set :refer [intersection]]))

(defn part-1
  "Day 06 Part 1"
  [input]
  (reduce + (map (fn [group]
                   (-> group
                       (string/replace #"\n" "")
                       (set)
                       (count)))
                 (split-p input))))

(defn part-2
  "Day 06 Part 2"
  [input]
  (reduce + (map (fn [group]
                   (count (apply intersection 
                                 (for [l (split-lines group)]
                                   (set l)))))
                 (split-p input))))
