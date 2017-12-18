(ns advent-of-code.day2
  (:require [clojure.string :as string]))

(defn part1-helper [[head & tail] acc]
  (if (nil? head)
    acc
    (part1-helper tail (+ acc (- (apply max head) (apply min head))))))

(defn part1-main [rows]
  (part1-helper rows 0))

(defn part1 [args]
  (let [rows (map (fn [row]
                    (map read-string (string/split row #"\s")))
                  (string/split (first args) #"\n"))
        checksum (part1-main rows)]
    (println checksum)))
