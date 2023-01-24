(ns echo.interface.actions
  (:require [seesaw.core :as core]
            [echo.rules :as rules]
            [clara.rules :refer [query]]
            [echo.queries :as queries]))


(defn progress-forward
  []
  (let [session (rules/session [(rules/config-fact)])]
    (query session queries/show-oneperone-page)))


(defn next-action
  [e]
  (core/alert e (progress-forward)))
