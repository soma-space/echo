(ns echo.interface.actions
  (:require [seesaw.core :as core]
            [echo.rules :as rules]
            [clara.rules :refer [query]]
            [echo.queries :as queries]))


(defn progress-forward
  []
  (let [session (rules/session)
        next-page (distinct
                    (map first
                         (mapcat first (filter seq [(query session queries/show-oneperone-page)
                                                    (query session queries/show-welcome-page)]))))]))


(defn next-action
  [e]
  (core/alert e (progress-forward)))
