(ns rosalind-clojure.problems.fib
  (:require [clojure.string :as s]))


(defn rabbit-sequence
  "Given k = number of offsprint pairs per generation, returns a sequence of
  the number of rabbits per generation.
  Formula: Given m matures and n immaturess, in the next generation we will
  have:
  - Inmatures: m*k
  - Matures: m+n"
  ([k]
   (cons [0 1] (lazy-seq (rabbit-sequence k 1 0))))
  ([k immatures matures]
   (let [new-immatures (* matures k)
         new-matures (+ immatures matures)]
     (cons [new-immatures new-matures]
           (lazy-seq (rabbit-sequence k new-immatures new-matures))))))

(defn final-rabbits
  [n k]
  (apply + (last (take n (rabbit-sequence k)))))

(defn preprocess-input
  [string]
  (map #(Integer. %)
    ((comp
       #(s/split % #"\s") ;; split by spaces
       s/trim)            ;; trim
       string)))

(defn solve-exercise
  [input-file]
  (apply final-rabbits (preprocess-input (slurp input-file))))
