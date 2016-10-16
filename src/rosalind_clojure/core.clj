(ns rosalind-clojure.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(def problem-to-solve "hamm")

;; Imports
(def script-ns (symbol (str "rosalind-clojure.problems." problem-to-solve)))
(def input-file (io/resource (str "inputs/rosalind_" problem-to-solve ".txt")))
(require [script-ns :as 'problem])

(defn -main
  [& args]
  (println (problem/solve-exercise input-file)))
