(ns app.prime)

(defn odd-prime?
  "NGestest prime tapi cuma yg ganjil > 2"
  [p]
  (every? #(pos? (rem p %)) (range 3 p)))
