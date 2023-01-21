(ns echo.domain.mssql
  (:require [echo.cli :refer [powershell]]
            [echo.domain.tasks :as tasks]))


(defn mssql-exists?
  [registry-key]
  (boolean (powershell ["REG" "QUERY" (str "'" registry-key "'")])))


(defn mssql-running?
  [exe]
  (tasks/exe-running? exe))


(defn mssql-instance-connectable?
  [name]
  (boolean (powershell ["sqlcmd" "-S" (str "localhost" \\ name) "-Q" "'SELECT @@VERSION'"])))
