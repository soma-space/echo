(ns echo.domain
  (:require [clojure.string :as string]
            [echo.cli :as cli]
            [clojure-ini.core :refer [read-ini]]))


(defn memory-64bit?
  []
  (string/ends-with? (System/getProperty "os.arch") "64"))


(defn mssql-exists?
  [registry-key]
  (not= "" (cli/reg ["QUERY" (str "'" registry-key "'")])))


(defn mssql-instance-connectable?
  [name]
  (not= "" (cli/sqlcmd ["-S" (str "localhost" \\ name) "-Q" "'SELECT @@VERSION'"])))


(defn load-config
  []
  (read-ini "resources/config.ini" {:keywordize? true}))


(comment
  (load-config))

