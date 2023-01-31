(ns echo.rules.config
  (:require [clara.rules :refer [defrule insert!]]
            [echo.config :refer [get-config]]))


(defrule configuration
  [:test (true? true)]
  =>
  (insert! (into (get-config)
                 {:fact :configuration})))
