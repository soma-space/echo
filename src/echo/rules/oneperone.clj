(ns echo.rules.oneperone
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain.tasks :as tasks]
            [echo.interface.oneperone :refer [oneperone-page]]))


(defrule oneperone-running
  [:mssql-exists]
  [?config <- :configuration]
  [:test (tasks/exe-running? (-> ?config :oneperone :exe))]
  =>
  (insert! {:fact :oneperone-running}))


(defrule oneperone-not-running
  [:not [:oneperone-running]]
  =>
  (insert! {:fact :oneperone-not-running
            :display oneperone-page}))
