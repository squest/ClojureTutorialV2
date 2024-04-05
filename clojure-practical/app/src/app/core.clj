(ns app.core
  (:require
    [app.prime :as prime]
    [app.list.remake :as lst]
    [clojure.string :as cs]
    [clojure.set :as cset]
    [clojure.edn :as edn]))

(defn square [x] (* x x))

(def lst (range 1 5))

(defonce app-state (atom {:count 5}))

(defn prime-list [lim]
  (->> (range 3 (inc lim))
       (filter prime/odd-prime?)
       (cons 2)))

(defn cslurp
  "Read file and return as clojure edn"
  [f]
  (edn/read-string (slurp f)))

