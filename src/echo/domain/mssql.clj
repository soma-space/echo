(ns echo.domain.mssql
  (:require [echo.cli :refer [powershell]]))


(defn mssql-exists?
  [registry-key]
  (boolean (powershell ["REG" "QUERY" (str "'" registry-key "'")])))


(defn mssql-instance-connectable?
  [name]
  (boolean (powershell ["sqlcmd" "-S" (str "localhost" \\ name) "-Q" "'SELECT @@VERSION'"])))
