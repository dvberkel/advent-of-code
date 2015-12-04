(ns solver.core
  (:gen-class))

(defn determine-floor [word]
  "Determines which floor Santa should deliver presents"
  (let [freqs (frequencies word)] (- (get freqs \( 0) (get freqs \) 0))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (determine-floor (slurp "input"))))
