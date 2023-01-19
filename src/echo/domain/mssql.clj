(ns echo.domain.mssql
  (:require [echo.cli :as cli]))


(defn mssql-exists?
  [registry-key]
  (zero? @(:exit-code (cli/reg ["QUERY" (str "'" registry-key "'")]))))


(defn mssql-instance-connectable?
  [name]
  (cli/sqlcmd ["-S" (str "localhost" \\ name) "-Q" "'SELECT @@VERSION'"]))
