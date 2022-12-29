(ns echo.rules
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain :refer [memory-64bit?]]))


(defrule memory-64bit
  [:test (memory-64bit?)]
  =>
  (insert! {:fact-type :memory-64bit}))

