(ns rosalind-clojure.utils.dna
  (:require [clojure.string :as s]))


(defn label?
  [line]
  (= (get line 0) \>))

(defn sequences-only
  "Given an array of lines, mixed sequences & labels, return only the sequences."
  [lines]
  (reduce (fn
           [old-array line]
            ;; is it a label? skip it
            (if (label? line)
              (conj old-array "")
              (assoc old-array (dec (count old-array)) (str (last old-array) line))))
          []
          lines))
              
(defn load-sequences
  "Load sequences from a file, return a dictionary {label: sequence}."
  [filename]
  (let [lines (s/split (slurp filename) #"\n")]
    (zipmap (map #(s/replace % #"^>" "") (filter label? lines))
            (sequences-only lines))))

(defn gc-content
  [dna]
  (let [gc-count (count (filter #(or (= % \G) (= % \C)) dna))
        total-count (count dna)]
    (float (/ gc-count total-count))))

