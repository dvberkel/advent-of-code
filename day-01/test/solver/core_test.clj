(ns solver.core-test
  (:require [clojure.test :refer :all]
            [solver.core :refer :all]))

(deftest determine-floor-test
  (testing "should determine correct floor"
    (is (= (determine-floor "(())")    0))
    (is (= (determine-floor "(((")     3))
    (is (= (determine-floor "))(((((") 3))
    (is (= (determine-floor ")))")     -3))
    (is (= (determine-floor ")())())") -3))))
