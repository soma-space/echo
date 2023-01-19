(ns echo.cli
  (:require [me.raynes.conch :refer [run-command]]))

(defn powershell
  ([args]
   (powershell args {}))
  ([args options]
   (run-command
     "powershell"
     args
     (merge {:throw false :timeout 5000}
            options))))


(defn reg
  [args]
  (powershell (into ["REG"] args)))


(comment
  (reg ["QUERY" "'HKLM\\SOFTWARE\\MICROSOFT\\Microsoft SQL Server'"]))


(defn sqlcmd
  [args]
  (powershell (into ["sqlcmd"] args)))

(comment
  (sqlcmd ["-S" "localhost\\sqlexpress" "-Q" "'SELECT @@VERSION'"]))
