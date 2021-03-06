(ns solver.core
  (:use [clojure.string :only [split]])
  (:gen-class))

(defn areas [w h l] [(* w h) (* w l) (* h l)])
(defn wrapping-paper [a b c] (+ (* 2 a) (* 2 b) (* 2 c)))
(defn slack [a b c] (min a b c))
(defn paper [[w h l]] (let [[a b c] (areas w h l)]
                     (+ (wrapping-paper a b c) (slack a b c))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (with-open [rdr (clojure.java.io/reader "input")]
    (let [split-on-x (fn [dimension] (map read-string (split dimension #"x")))
          dimensions (line-seq rdr)]
      (println (reduce + (map paper (map split-on-x dimensions)))))))
