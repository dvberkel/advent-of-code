(ns solver.core
  (:gen-class))

(defn create-grid
  ([] (create-grid 1000))
  ([w] (create-grid w w))
  ([w h] (let [row (vec (map (fn [x] false) (range w)))
               grid (vec (map (fn [x] row) (range h)))]
           grid)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
