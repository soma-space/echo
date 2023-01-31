(ns echo.interface.actions
  (:require [echo.rules :as rules]))


(defn progress-forward
  []
  (let [rules (filter :display (rules/fire))]
    (assert (= 1 (count rules)) "More than one display matches")
    (for [{display :display} rules]
      (display))))


(defn next-action
  [_]
  (doall
    (progress-forward)))
