(ns rosalind-clojure.problems.hamm
  (:require [clojure.string :as s]))

(defn hamming-distance
  [dna1 dna2]
  (count (filter (complement identity) (map #(= %1 %2) dna1 dna2))))

(defn solve-exercise
  [input-file]
  (let [content (slurp input-file)
        [dna1 dna2] (s/split content #"\n")]
    (hamming-distance dna1 dna2)))
