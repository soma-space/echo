(ns echo.rules
  (:require [clara.rules :refer [defrule insert! mk-session insert-all fire-rules]]
            [clara.tools.inspect :as inspect]
            [echo.domain :as domain]))

;(defrule memory-64bit
;  [:test (domain/memory-64bit?)]
;  =>
;  (insert! {:fact-type :memory-64bit}))


(defrule mssql-exists
  [?config <- :configuration]
  [:test (domain/mssql-exists? (get-in ?config [:mssql :registry-key]))]
  =>
  (insert! {:fact-type :mssql-exists}))

(def facts [(into (domain/load-config) {:fact-type :configuration})])

(defn fire
  []
  (-> (mk-session 'echo.rules :fact-type-fn :fact-type)
      (insert-all facts)
      (fire-rules)
      (inspect/inspect)
      :fact->explanations
      keys))
