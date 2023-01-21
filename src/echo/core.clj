(ns echo.core
  (:require [echo.rules :refer [fire]]
            [echo.interface :refer [setup]]
            [echo.interface.welcome :refer [welcome-frame]]))


(defn -main
  [& _]
  (setup)
  (welcome-frame))


(comment
  (fire))

(comment
  (do (setup)
      (welcome-frame)))
