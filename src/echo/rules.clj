(ns echo.rules
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain :as domain]))


(defrule memory-64bit
  [:test (domain/memory-64bit?)]
  =>
  (insert! {:fact-type :memory-64bit}))


(defrule mssql-exists
  [:test (domain/mssql-exists?)]
  =>
  (insert! {:fact-type :mssql-exists}))
