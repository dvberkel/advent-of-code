(ns solver.core
  (:gen-class))

(defn create-grid
  ([] (create-grid 1000))
  ([w] (create-grid w w))
  ([w h] (let [row (vec (map (fn [x] false) (range w)))
               grid (vec (map (fn [x] row) (range h)))]
           grid)))

(defn act-on
  ([f row a b] (let [low a
                     high (+ b 1)
                     difference (- high low)]
                 (vec (concat
                       (take low row)
                       (map f (take difference (drop low row)))
                       (drop high row)))))
  ([f grid a b c d] (let [low a
                          high (+ c 1)
                          difference (- high low)
                          act-on-row (fn [row] (act-on f row b d))]
                      (vec (concat
                            (take low grid)
                            (map act-on-row (take difference (drop low grid)))
                            (drop high grid))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
