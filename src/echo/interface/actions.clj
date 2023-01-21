(ns echo.interface.actions
  (:require [seesaw.core :as core]
            [echo.rules :as rules]))


(defn next-action
  [e]
  (core/alert e (rules/explain)))
