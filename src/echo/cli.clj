(ns echo.cli
  (:require [me.raynes.conch :refer [run-command]]))

(defn powershell
  ([args]
   (powershell args {}))
  ([args options]
   (run-command
     "powershell"
     args
     (into {:timeout 5000 :verbose true :throw false}
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


(defn tasklist
  [args]
  (powershell (into ["tasklist"] args)))
