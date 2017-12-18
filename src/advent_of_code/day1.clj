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

(defn part2-helper [[head & tail] full-list current-index last-num acc]
  (let [halfway-around-list (nth full-list
                                 (mod (+ current-index
                                         (/ (count full-list) 2))
                                      (count full-list)))]
    (if (nil? head)
      (if (= last-num halfway-around-list)
        (+ acc last-num)
        acc)
      (part2-helper tail full-list (inc current-index) head (if (= head halfway-around-list)
                                                             (+ acc head)
                                                             acc)))))

(defn part2-main [nums]
  (part2-helper nums nums 0 (first nums) 0))

(defn run [part-func args]
  (let [nums (-> args
                 (string/join)
                 (str->nums))
        sum (part-func nums)]
    (println sum)))

(defn part1 [args]
  (run part1-main args))

(defn part2 [args]
  (run part2-main args))
