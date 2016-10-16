(ns rosalind-clojure.problems.revc)

(def half-complements {\A \T \C \G})

(defn complete-complements
  [half-map]
  (reduce #(assoc %1 (get %1 %2) %2) half-map (keys half-map)))

(defn reverse-complement
  [dna-string]
  (let [complement-map (complete-complements half-complements)]
    (clojure.string/join "" (reverse (map #(get complement-map %) dna-string)))))

(defn solve-exercise
  [input-file]
  (reverse-complement (clojure.string/trim (slurp input-file))))
