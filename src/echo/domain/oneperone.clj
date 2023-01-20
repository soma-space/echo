(ns echo.domain.oneperone
  (:require [echo.cli :refer [tasklist]]
            [clojure.string :as str]))


(defn oneperone-running?
  [exe]
  (not (str/starts-with?
         (tasklist ["/FI \"\"IMAGENAME eq " exe "\"\""])
         "INFO:")))

(comment
  (oneperone-running? "notepad.exe"))

