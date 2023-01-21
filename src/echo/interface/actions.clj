(ns echo.interface.actions
  (:require [seesaw.core :as core]
            [echo.rules :refer [fire]]))


(defn next-action
  [e]
  (core/alert e (fire)))
