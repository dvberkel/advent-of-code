(ns solver.core
  (:gen-class))

(defn- to-direction [index direction] { :index index :direction direction })

(defn determine-floor [xs]
  (let [
        determine-floor (fn [floor data] (+ floor  (case (data :direction)
                                             "(" +1
                                             ")" -1)))]
    (reduce determine-floor 0  (map-indexed to-direction xs))))

(defn first-basement [directions]
  (let [to-floor (fn [direction] (assoc direction
                                        :floor (determine-floor
                                                (take (direction :index) directions))))
        hit-basement (fn [data] (= (data :floor) -1))]
    (first (filter hit-basement (map to-floor (map-indexed to-direction directions))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [directions (clojure.string/split (slurp "input") #"")]
    (println (determine-floor directions))
    (println (first-basement directions))))

