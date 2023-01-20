(ns echo.cli
  (:require [me.raynes.conch :refer [run-command]]))


(defn title-print!
  [title content]
  (println title)
  (println "---")
  (println content)
  (println "---"))

(defn powershell
  ([args]
   (powershell args {}))
  ([args options]
   (let [result (run-command
                  "powershell"
                  args
                  (into {:timeout 5000 :verbose true :throw false}
                        options))]
     (if (zero? @(:exit-code result))
       (:stdout result)
       (do (title-print! "Powershell Command" args)
           (title-print! "Standard Error" (:stderr result))
           nil)))))


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
