(ns echo.domain.tasks
  (:require [echo.cli :refer [powershell]]
            [clojure.string :as str]))


(defn exe-running?
  [exe]
  (not (str/starts-with?
         (powershell ["tasklist" "/FI \"\"IMAGENAME eq " exe "\"\""])
         "INFO:")))


(comment
  (exe-running? "notepad.exe"))
