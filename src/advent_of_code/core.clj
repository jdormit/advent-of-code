(ns advent-of-code.core
  (:require [clojure.string :as string]
            [advent-of-code.day1 :as day1])
  (:gen-class))


(defn -main
  [func & args]
  (eval (read-string (str "(advent-of-code."
                          func
                          " (quote "
                          args
                          "))"))))
