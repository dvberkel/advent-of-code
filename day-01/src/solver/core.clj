(ns solver.core
  (:gen-class))

(defn determine-floor [word]
  "Determines which floor Santa should deliver presents"
  (let [freq (frequencies word)]
    (- (freq \()) (freq \))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (determine-floor (slurp "input"))))
