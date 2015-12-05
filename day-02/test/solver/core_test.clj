(ns solver.core-test
  (:require [clojure.test :refer :all]
            [solver.core :refer :all]))

(deftest a-paper
  (testing "it should determine amount of paper from dimensions"
    (is (= (paper 2 3 4) 58))
    (is (= (paper 1 1 10) 43))))
