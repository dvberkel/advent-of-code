(ns solver.core
  (:require clojure.set clojure.string)
  (:gen-class))

(defn move-to [[x y] [dx dy]] [(+ x dx) (+ y dy)])

(defn to-direction [character] (case character
                                 ">" [ 1  0]
                                 "<" [-1  0]
                                 "^" [ 0  1]
                                 "v" [ 0 -1]))

(defn reducer [data direction]
  (let [next-current (move-to (data :current) direction)
        next-data { :visited (clojure.set/union (data :visited) #{next-current})
                   :current next-current}]
    next-data))

(defn visited-houses [description]
  (let [steps (clojure.string/split description #"")
        directions (map to-direction steps)
        initial { :visited #{ [0 0] } :current [0 0] }]
    (reduce reducer initial directions)))

(defn count-visited-houses [description]
  (count ((visited-houses description) :visited)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (count-visited-houses (slurp "input"))))
