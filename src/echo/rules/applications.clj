(ns echo.rules.applications
  (:require [clara.rules :refer [defrule insert!]]
            [echo.domain :as domain]))


(defrule oneperone-running
  [?config <- :configuration]
  [:test (domain/oneperone-running?)]
  =>
  (insert! {:fact-type :oneperone-running}))
