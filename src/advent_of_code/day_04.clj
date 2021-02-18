(ns advent-of-code.day-04
  "AOC 2020 Day 4"
  (:require [advent-of-code.util :refer [split-lines split-p]]
            [clojure.string :refer [split]]))

(defn parse-passport
  [passport]
  (->> passport
       (re-seq #"(\S+):(\S+)")
       (reduce (fn [m entry]
                 (assoc m
                        (keyword (entry 1))
                        (entry 2)))
               {})))

(defn byr? [p] (<= 1920 (read-string (:byr p)) 2002))
(defn iyr? [p] (<= 2010 (read-string (:iyr p)) 2020))
(defn eyr? [p] (<= 2020 (read-string (:eyr p)) 2030))

(defn hgt? 
  [p]
  (let [f (split (:hgt p) #"\D" 2)]
    (if (not (= (count f) 2))
      false
      (case (f 1)
        "m" (<= 150 (read-string (f 0)) 193)
        "n" (<= 59 (read-string (f 0)) 76)
        :else false))))

(defn hcl? [p] (not (nil? (re-matches #"#([0-9]|[a-f]){6}" (:hcl p))))) 
(defn ecl? 
  [p] 
  (condp = (:ecl p)
    "amb" true
    "blu" true
    "brn" true
    "gry" true
    "grn" true
    "hzl" true
    "oth" true
    false))
(defn pid? [p] (not (nil? (re-matches #"[0-9]{9}" (:pid p)))))

(defn valid?
  [p]
  (cond 
    (not (byr? p)) false
    (not (iyr? p)) false
    (not (eyr? p)) false
    (not (hgt? p)) false
    (not (hcl? p)) false
    (not (ecl? p)) false
    (not (pid? p)) false
    :else true))

(defn present? 
  [p] 
  (cond 
    (not (contains? p :byr)) false
    (not (contains? p :eyr)) false
    (not (contains? p :iyr)) false
    (not (contains? p :ecl)) false
    (not (contains? p :hcl)) false
    (not (contains? p :hgt)) false
    (not (contains? p :pid)) false 
    :else true))

(defn part-1
  "Day 04 Part 1"
  [input]
  (->> input
       (split-p)
       (map parse-passport) 
       (filter present?)
       (count)))

(defn part-2
  "Day 04 Part 2"
  [input]
  (->> input
       (split-p)
       (map parse-passport) 
       (filter present?)
       (filter valid?)
       (count)))
