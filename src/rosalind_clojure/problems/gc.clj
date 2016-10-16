(ns rosalind-clojure.problems.gc
  (:require [clojure.string :as s]
            [rosalind-clojure.utils.dna :as dna]))

(defn sequences-gc-content
  [sequences]
  (reduce #(assoc %1 %2 (dna/gc-content (get %1 %2)))
          sequences
          (keys sequences)))

(defn max-in-map
  [sequences]
  (let [pairs (sequence sequences)]
    (first (sort #(> (last %1) (last %2)) sequences))))

(defn solve-exercise
  [input-file]
  (let [[k perc] (max-in-map (sequences-gc-content (dna/load-sequences input-file)))]
    (println (str k "\n" (format "%.6f" (* 100 perc))))))
