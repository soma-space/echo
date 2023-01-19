(ns echo.rules
  (:require [clara.rules :refer [fire-rules insert-all mk-session]]
            [clara.tools.inspect :as inspect]
            [echo.domain :as domain]
            [echo.rules.applications]
            [echo.rules.mssql]))


(def facts [(into (domain/load-config) {:fact-type :configuration})])

(defn fire
  []
  (-> (mk-session
                  'echo.rules.applications
                  'echo.rules.mssql
                  :fact-type-fn :fact-type)
      (insert-all facts)
      (fire-rules)
      (inspect/inspect)
      :fact->explanations
      keys))
