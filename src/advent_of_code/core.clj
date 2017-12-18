(ns advent-of-code.core
  (:require [clojure.string :as string]
            [advent-of-code.day1 :as day1])
  (:gen-class))


(defn -main
  [& args]
  (day1/part1 args))
