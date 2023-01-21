(ns echo.rules.oneperone
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain.tasks :as tasks]))


(defrule oneperone-running
  [:mssql-exists]
  [?config <- :configuration]
  [:test (tasks/exe-running? (-> ?config :oneperone :exe))]
  =>
  (insert! {:fact :oneperone-running}))
