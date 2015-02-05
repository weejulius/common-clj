(ns common.core
  "move the following funs")

(defn between
  "Check if the num is between two values"
  [num low high]
  (and (< num high) (> num low)))


(defn load-sym
  "load the symbol to use"
  [s]
  (require (symbol (namespace s)))
  (resolve s))

