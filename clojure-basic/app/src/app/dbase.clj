(ns app.dbase)

(defn freq-by
  "It's like frequency, but it's by a function"
  [f coll]
  (->> (group-by f coll)
       (map (fn [[k v]] [k (count v)]))
       (into {})))

(defonce students
         (for [i (shuffle (range 1 30))]
           (let [fname (rand-nth ["Johny" "Jack" "Joanie" "Jane" "Captain" "Suzzie"])
                 lname (rand-nth ["Daniels" "Walker" "Morgan" "Doe" "Sparrow"])
                 mob (rand-nth ["Jan" "Feb" "Mar" "Apr" "May" "Jun"])
                 city (rand-nth ["Depok" "Bekasi" "Lamongan" "Pacitan"])
                 score (rand-nth (range 40 101))]
             {:id i
              :name {:first fname :last lname}
              :mob mob
              :city city
              :score score})))
