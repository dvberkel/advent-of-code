(ns solver.core
  (:gen-class))

(def vowels #{"a" "e" "i" "o" "u"})
(defn contains-at-least-three-vowels [word]
  (>= (count (filter vowels (clojure.string/split word #""))) 3))
(defn contains-repeated-letter [word]
  (re-find #"(\w)\1" word))
(defn contains-forbidden-string [word]
  (re-find #"ab|cd|pq|xy" word))

(defn nice-word [word]
  (and
   (contains-at-least-three-vowels word)
   (contains-repeated-letter word)
   (not
    (contains-forbidden-string word))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (with-open [rdr (clojure.java.io/reader "input")]
    (println (count (filter nice-word (line-seq rdr))))))
