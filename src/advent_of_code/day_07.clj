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

(defn trimmed-keyword [k] (keyword (clojure.string/replace k #"\s" "-")))
  
(defn parse-line-to-map
  [line graph]
  (let [line (parse-line line)
        outer-bag (trimmed-keyword (line 0))
        graph (add-node graph outer-bag)
        inner-bags (line 1)
        mapper (fn 
                 [graph bag]
                 (add-edge graph 
                           outer-bag 
                           (trimmed-keyword (bag 0)) 
                           (bag 1)))]
    (loop [inner-bags inner-bags
           graph graph]
      (if (empty? inner-bags)
        graph
        (recur (rest inner-bags)
               (mapper graph (first inner-bags)))))))

(defn build-graph
  [lines]
  (loop [lines lines
         graph nil]
    (if (empty? lines)
      graph
      (recur (rest lines)
             (parse-line-to-map (first lines) graph)))))
