(ns echo.user-interface.actions
  (:require [seesaw.core :as core]))


(defn next-action
  [e]
  (core/alert e "TODO!!"))

;(defn next-action
;  []
;  (let [rules (-> (mk-session 'echo.rules
;                              :fact-type-fn :fact-type)
;                  (fire-rules)
;                  (inspect/inspect)
;                  :fact->explanations
;                  keys)]
;    (println rules)))
