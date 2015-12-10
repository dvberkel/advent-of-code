(ns solver.core-test
  (:require [clojure.test :refer :all]
            [solver.core :refer :all]))

(deftest a-nice-word-test
  (testing "should test if words are nice"
    (is (nice-word "ugknbfddgicrmopn"))
    (is (nice-word "aaa"))
    (is (not (nice-word "jchzalrnumimnmhp")))
    (is (not (nice-word "haegwjzuvuyypxyu")))
    (is (not (nice-word "dvszwmarrgswjxmb")))))
