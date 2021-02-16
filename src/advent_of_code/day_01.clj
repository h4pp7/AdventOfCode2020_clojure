(ns advent-of-code.day-01
   "AOC 2020 Day 1"
  (:require
    [clojure.java.io :refer [reader]])
  (:require
    [clojure.string :as string])
  (:gen-class))

(defn parse-input
  "parses the input into a vector of ints"
  [input]
  (let [data (-> input
               	 string/trim
                 (#(string/split % #"\n")))]
    (map #(Integer/parseInt %) data)))

(defn part-1
  "Day 01 Part 1"
  [input]
  (def data (parse-input input))
  (first
    (for [a data, b data
          :when (= 2020 (+ a b))]
      (* a b))))

(defn part-2
  "Day 01 Part 2"
  [input]
  (def data (parse-input input))
  (first
    (for [a data, b data, c data
          :when (= 2020 (+ a b c))]
      (* a b c))))
