(ns echo.cli
  (:require [me.raynes.conch :refer [run-command]]))


(defn powershell
  [args]
  (run-command "powershell" args {:throw false}))


(defn quote
  [x]
  (str \\ \" \"  x \" \\ \"))


(defn reg-query
  [args]
  (powershell (into ["REG" "QUERY"] (mapv quote args))))


(comment
  (reg-query ["HKLM\\SOFTWARE\\MICROSOFT\\Microsoft SQL Server"]))
