(ns echo.rules
  (:require [clara.rules :refer [fire-rules insert-all mk-session]]
            [clara.tools.inspect :as inspect]
            [echo.queries]
            [echo.rules.config]
            [echo.rules.oneperone]
            [echo.rules.mssql]))


(defn session
  ([] (session []))
  ([facts]
   (-> (mk-session 'echo.rules.config
                   'echo.rules.oneperone
                   'echo.rules.mssql
                   'echo.queries
                   :fact-type-fn :fact)
       (insert-all facts)
       (fire-rules))))


(defn fire
  []
  (-> (session)
      (inspect/inspect)
      :fact->explanations
      keys))


(defn explain
  []
  (-> (session)
      (inspect/explain-activations)))
