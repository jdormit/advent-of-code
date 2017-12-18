(ns advent-of-code.day1
  (:require [clojure.string :as string]))

(defn part1-helper [[head & tail] first-num last-num acc]
  (if (nil? head)
    (if (= first-num last-num)
      (+ acc last-num)
      acc)
    (part1-helper tail first-num head (+ acc (if (= head (first tail))
                                                        head
                                                        0)))))
(defn part1-main [nums]
  (part1-helper nums (first nums) (first nums) 0))

(defn str->nums [str] (map read-string (string/split str #"")))

(defn part1 [args]
  (let [nums (-> args
                 (string/join)
                 (str->nums))
        sum (part1-main nums)]
    (println sum)))
