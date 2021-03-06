(ns ^{:doc "common used functions
            #TODO re-move"}
  common.func
  (:require [common.logging :as log]))

(defn cond-update
  "update entry with new if pre? is satisfied"
  [new-entry pre?]
  (fn [entry]
    (if (pre? entry)
      (if (fn? new-entry)
        (new-entry)
        new-entry)
      entry)))

(defn put-if-absence
  [m path new-entry]
  (update-in m path
             #((cond-update new-entry nil?) %)))

(defn put-if-absence!
  "load entry from atom data structure, put one if it is not existing,
   the `path` is the path of the nested keys to get the entry"
  [entries path new-entry]
  (swap! entries
         (fn [m]
           (put-if-absence m path new-entry))))


(defn filter-until
  "apply f to  filter coll until pre-fn is satisfied"
  [f pre-fn coll]
  (loop [col coll
         result nil]
    (let [v (first col)]
      (if (and v (pre-fn result))
        (recur (rest col)
               (if (f v)
                 (conj (vec result) v)
                 result))
        (seq result)))))
