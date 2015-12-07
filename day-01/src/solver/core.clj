(ns solver.core
  (:gen-class))

(defn determine-floor [xs]
  (let [to-direction (fn [index direction] {:index index :direction direction})
        determine-floor (fn [floor data] (+ floor  (case (data :direction)
                                             "(" +1
                                             ")" -1)))]
    (reduce determine-floor 0  (map-indexed to-direction xs))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [directions (clojure.string/split (slurp "input") #"")]
    (println (determine-floor directions))))

