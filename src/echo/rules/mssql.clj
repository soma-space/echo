(ns echo.rules.mssql
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain :as domain]))


(defrule mssql-exists
  [?config <- :configuration]
  [:test (domain/mssql-exists? (-> ?config :mssql :registry-key))]
  =>
  (insert! {:fact-type :mssql-exists}))
