(ns one.file
  (:require [clj-uuid :as uuid]
            [cheshire.core :as json]
            [clojure.pprint :as pp]
            [clojure.edn :as edn]))

(defn uuid
  []
  (str (clj-uuid/v1)))

(defn cslurp
  "Helper function to easily slurp and read-string a file"
  [fname]
  ((comp edn/read-string slurp) fname))

(defn cspit
  "Helper function to beautifully print clojure to file"
  [fname data]
  (->> data pp/pprint with-out-str (spit fname)))

(defn col-data
  [col-name]
  (try (cslurp (str "resources/" col-name ".edn"))
       (catch Exception e)))

(defn create-collection
  [col-name]
  (let [file-check? (col-data col-name)]
    (if file-check?
      (println "Collection already exists")
      (do (spit (str "resources/" col-name ".edn") [])
          (spit (str "resources/" col-name ".json")
                (json/generate-string []))))))

(defn fcol [col-name format]
  (if (= format :edn)
    (str "resources/" col-name ".edn")
    (str "resources/" col-name ".json")))

(defn add-doc!
  [col-name data]
  (if-let [colls (col-data col-name)]
    (let [tbu (conj colls (assoc data :id (uuid)))]
      (cspit (fcol col-name :edn) tbu)
      (spit (fcol col-name :json) (json/generate-string tbu)))
    (println "Collection does not exist")))
















