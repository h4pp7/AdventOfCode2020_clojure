(ns advent-of-code.day-07-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-07 :refer :all]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected 4]
    (is (= expected (part-1 (slurp (resource "day-07-example.txt")))))))

(deftest part2
  (let [expected 32]
    (is (= expected (part-2 (slurp (resource "day-07-example.txt")))))))

(deftest part2-2
  (let [expected 126]
    (is (= expected (part-2 (slurp (resource "day-07-example-2.txt")))))))

(deftest part1-solution
  (let [expected 289]
    (is (= expected (part-1 (slurp (resource "day-07.txt")))))))

(deftest part2-solution
  (let [expected 30055]
    (is (= expected (part-2 (slurp (resource "day-07.txt")))))))
