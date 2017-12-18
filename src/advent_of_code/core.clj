(ns advent-of-code.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn sum-of-matches-helper [[head & tail] first-num last-num acc]
  (if (nil? head)
    (if (= first-num last-num)
      (+ acc last-num)
      acc)
    (sum-of-matches-helper tail first-num head (+ acc (if (= head (first tail))
                                                    head
                                                    0)))))
(defn sum-of-matches [nums]
  (sum-of-matches-helper nums (first nums) (first nums) 0))

(defn str->nums [str] (map read-string (string/split str #"")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [nums (-> args
                 (string/join)
                 (str->nums))
        sum (sum-of-matches nums)]
    (println sum)))
