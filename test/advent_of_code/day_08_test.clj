(ns advent-of-code.day-08-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-08 :refer [part-1 part-2 parse-instruction step acc]]
            [clojure.java.io :refer [resource]]))

(deftest parse-pos-instruction
  (let [expected ['acc 1]]
    (is (= expected (parse-instruction "acc +1")))))

(deftest parse-neg-instruction
  (let [expected ['jmp -4]]
    (is (= expected (parse-instruction "jmp -4")))))

(deftest parse-zero-instruction
  (let [expected ['nop +0]]
    (is (= expected (parse-instruction "nop +0")))))

(deftest test-acc
  (let [expected  {:ACC 4 :PC 1}
        state     {:ACC 0 :PC 0}]
    (is (= expected (acc state 4)))))

(deftest steptest
  (let [expected  {:ACC 4 :PC 1}
        state     {:ACC 0 :PC 0}
        instr     "acc +4"]
    (is (= expected (step state instr)))))

(deftest part1
  (let [expected nil]
    (is (= expected (part-1 (slurp (resource "day-08-example.txt")))))))

(deftest part2
  (let [expected nil]
    (is (= expected (part-2 (slurp (resource "day-08-example.txt")))))))
