(ns echo.rules.applications
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain.applications :as domain]))


(defrule oneperone-running
  [:mssql-exists]
  [?config <- :configuration]
  [:test (domain/oneperone-running?)]
  =>
  (insert! {:fact-type :oneperone-running}))
