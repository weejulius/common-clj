(ns common.reqres
  "utilized to tap the http req or resp")

(defn ->template-param
  "convert from ds to param can be used by template engine
   which does not support keyword and name has - etc"
  [params]
  (into
    {}
    (for [[k v] params]
      [(clojure.string/replace (name k) #"-" "_")
       v])))
