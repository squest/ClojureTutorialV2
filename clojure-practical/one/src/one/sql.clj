(ns one.sql
  (:require [clojure.java.jdbc :as jdbc]
            [clj-uuid :as uuid])
  (:gen-class))

(defonce db
         {:classname   "org.sqlite.JDBC"
          :subprotocol "sqlite"
          :subname     "db/database.db"})

(defn uuid [] (str (uuid/v1)))

(defn create-table
  [db table-name table-spec]
  (try (->> (concat [[:timestamp :datetime :default :current_timestamp]
                     [:id :text]]
                    table-spec)
            (jdbc/create-table-ddl table-name)
            (jdbc/db-do-commands db))
       (catch Exception e (println (.getMessage e)))))

(defn create-db
  "create db and table"
  []
  (try (jdbc/db-do-commands
         db
         (jdbc/create-table-ddl :articles
                                [[:timestamp :datetime :default :current_timestamp]
                                 [:title :text]
                                 [:content :text]]))
       (catch Exception e
         (println (.getMessage e)))))

(def data
  (for [i (range 50 80)]
    (let [fname (rand-nth ["Jack" "Johny" "Kahlua" "Captain"])
          lname (rand-nth ["Daniels" "Walker" "Gutenstag" "Vibe" "Jaeger"])
          city (rand-nth ["Lualua" "Wakanda" "Forever" "Cikujang"])]
      {:fname fname :lname lname :city city :id (uuid)})))

(def courses
  (for [i (range 20)]
    (let [fname (rand-nth ["Intro to " "Beginning " "Intermediate " "Advanced"])
          lname (rand-nth ["Mathematics" "Physics" "Anthropology" "Comp Science"])]
      {:name (str fname lname)
       :code i
       :id   (uuid)})))

