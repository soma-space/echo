(ns echo.domain.oneperone
  (:require [echo.cli :refer [tasklist]]))


(defn oneperone-running?
  []
  (println
    (tasklist ["/FI \"IMAGENAME eq oneperone.exe\""]))
  ; tasklist /FI "IMAGENAME eq oneperone.exe"
  true)

(comment
  (tasklist ["/FI \"IMAGENAME eq oneperone.exe\""]))
