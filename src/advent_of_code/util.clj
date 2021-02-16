(ns advent-of-code.util
  "AOC 2020 helper functions")

(defn read-input
  "Reads the file and returns its content as a string"
  [day]
  (slurp (clojure.java.io/resource day)))

(defn split-lines
  "splits a str at linebreak into a vector strings"
  [input]
  (-> input
      clojure.string/trim
      (#(clojure.string/split % #"\n"))))
