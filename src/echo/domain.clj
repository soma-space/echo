(ns echo.domain
  (:require [clojure.string :as string]
            [echo.cli :as cli]
            [seesaw.core :as core]))


(defn memory-64bit?
  []
  (string/ends-with? (System/getProperty "os.arch") "64"))


(defn mssql-exists?
  []
  (not= "" (cli/reg-query ["HKLM\\SOFTWARE\\MICROSOFT\\Microsoft SQL Server"])))


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

(comment
  (mssql-exists?))
