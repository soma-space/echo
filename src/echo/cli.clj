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


(comment
  (powershell ["REG" "QUERY" "'HKLM\\SOFTWARE\\MICROSOFT\\Microsoft SQL Server'"])
  (powershell ["sqlcmd" "-S" "localhost\\sqlexpress" "-Q" "'SELECT @@VERSION'"]))
