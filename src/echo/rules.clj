(ns echo.rules
  (:require [clara.rules :refer [fire-rules insert-all mk-session]]
            [clara.tools.inspect :as inspect]
            [echo.config :refer [get-config]]
            [echo.rules.oneperone]
            [echo.rules.mssql]))


(def facts [(into (get-config) {:fact :configuration})])

(defn fire
  []
  (-> (mk-session
                  'echo.rules.oneperone
                  'echo.rules.mssql
                  :fact-type-fn :fact)
      (insert-all facts)
      (fire-rules)
      (inspect/inspect)
      :fact->explanations
      keys))
