(ns echo.rules.oneperone
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain.oneperone :as domain]))


(defrule oneperone-running
  [:mssql-exists]
  [?config <- :configuration]
  [:test (domain/exe-running? (-> ?config :oneperone :exe))]
  =>
  (insert! {:fact :oneperone-running}))
