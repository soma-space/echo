(ns echo.rules
  (:require [clara.rules :refer [fire-rules insert-all mk-session]]
            [clara.tools.inspect :as inspect]
            [echo.config :refer [get-config]]
            [echo.queries]
            [echo.rules.oneperone]
            [echo.rules.mssql]))


(defn config-fact
  []
  (into (get-config) {:fact :configuration}))


(defn session
  [facts]
  (-> (mk-session 'echo.rules.oneperone
                  'echo.rules.mssql
                  'echo.queries
                  :fact-type-fn :fact)
      (insert-all facts)
      (fire-rules)))


(defn fire
  []
  (-> (session [(config-fact)])
      (inspect/inspect)
      :fact->explanations
      keys))


(defn explain
  []
  (-> (session [(config-fact)])
      (inspect/explain-activations)))
