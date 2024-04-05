(ns one.core
  (:require [clj-uuid :as uuid]))

(defonce db (atom {}))

(defn create-collection!
  [atm col-name]
  (swap! atm #(merge % {col-name []})))


;; student : id, nama, asal
(defn add-doc!
  [db col data]
  (let [cols (col @db)
        updated (->> (assoc data :id (count cols))
                     (conj cols))]
    (swap! db #(assoc % col updated))))

(defn update-doc!
  [db col id updated-data]
  (let [cols (col @db)
        old-data (->> cols
                      (filter #(= (:id %) id))
                      first)
        tbu (merge old-data (dissoc updated-data :id))
        updated-cols (-> (remove #(= (:id %) id) cols)
                         (conj tbu))]
    (swap! db #(assoc % col updated-cols))))
