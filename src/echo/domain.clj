(ns echo.domain
  (:require [clojure.string :as string]
            [echo.cli :as cli]))



(defn memory-64bit?
  []
  (string/ends-with? (System/getProperty "os.arch") "64"))


(defn mssql-exists?
  []
  (not= "" (cli/reg ["QUERY" "'HKLM\\SOFTWARE\\MICROSOFT\\Microsoft SQL Server'"])))


(defn mssql-instance-connectable?
  [name]
  (not= "" (cli/sqlcmd ["-S" (str "localhost" \\ name) "-Q" "'SELECT @@VERSION'"])))



(comment
  (mssql-exists?))
