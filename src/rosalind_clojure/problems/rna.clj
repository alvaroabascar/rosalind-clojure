(ns rosalind-clojure.problems.rna)

(defn transcribe-dna
  [dna-string]
  (clojure.string/join "" (map #(if (= % \T) \U %) dna-string)))

(defn solve-exercise
  [input-file]
  (transcribe-dna (slurp input-file))) 
