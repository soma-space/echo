(ns echo.interface.actions
  (:require [seesaw.core :as core]
            [echo.rules :as rules]))


(defn progress-forward
  []
  (let [rules (rules/fire)]))


(defn next-action
  [e]
  (core/alert e (progress-forward)))
