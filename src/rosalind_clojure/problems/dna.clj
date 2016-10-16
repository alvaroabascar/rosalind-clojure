(ns rosalind-clojure.problems.dna)

(defn dna-to-counts
  "Takes a DNA string, returns a map { :a n(A) :t n(T) :c n(C) :g n(G) }."
  [dna-string]
  (reduce (fn
            [new-map nuc-key]
            (let [old-count (nuc-key new-map 0)] ;; default count = 0
              (assoc new-map nuc-key (inc old-count))))
          {}
          (map (comp keyword str) dna-string)))

(defn count-nucleotides
  "Given a DNA string, returns the count of nucleotides, as a vector with
  4 integers: [A C G T]"
  [dna-string]
  (map #(% (dna-to-counts dna-string)) [:A :C :G :T]))

(defn solve-exercise
  "Solve the excercise"
  [input-file]
  (count-nucleotides (slurp input-file)))

