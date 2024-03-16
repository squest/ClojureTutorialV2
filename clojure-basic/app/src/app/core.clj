(ns app.core)

;; Coba bikin dong function prime-list yg terima input lim
;; terus gue pengen returnnya tuh [jumlah list-of-primes-less-than-lim]
;; algonya pake sieve ya, jadi pake boolean-array
;; let's change this part into something else

(defn prime-list
  "Generate list of primes less than lim"
  [lim]
  (let [primes (boolean-array lim true)
        sqrt-lim (Math/sqrt lim)]
    (doseq [i (range 2 (inc (int sqrt-lim)))]
      (if (aget primes i)
        (doseq [j (range (* i i) lim i)]
          (aset primes j false))))
    (->> primes
         (map-indexed vector)
         (filter second)
         (map first)
         (vec))))

(defn prime? [n]
  (cond (< n 2) false
        (== n 2) true
        (even? n) false
        :else (->> (range 3 n 2)
                   (take-while #(<= (* % %) n))
                   (every? #(pos? (rem n %))))))



(defn next-prime
  "Find the next prime number after n, n is an odd-prime"
  [n]
  (let [odd-prime? (fn [n]
                     (->> (range 3 n 2)
                          (take-while #(<= (* % %) n))
                          (every? #(pos? (rem n %)))))]
    (loop [i (+ n 2)]
      (if (odd-prime? i)
        i
        (recur (+ i 2))))))

(defn prime-factors
  "Return the prime-factors of a number"
  [num]
  (loop [n num cprime 3 factors []]
    (if (> (* cprime cprime) num)
      factors
      (if (zero? (rem n cprime))
        (recur (quot n cprime) cprime (conj factors cprime))
        (recur n (next-prime cprime) factors)))))

(defn sieve-factors
  "Return the result of sieving the numbers"
  [lim]
  (let [nums (int-array (range lim))]
    (loop [i 2]
      (if (< i lim)
        (do (loop [j (+ i i)]
              (when (< j lim)
                (aset nums j (quot (aget nums j) (aget nums i)))
                (recur (+ j i))))
            (recur (inc i)))
        (rest (vec nums))))))






























