(ns echo.core
  (:require [echo.rules :refer [fire]]
            [echo.user-interface :refer [setup]]
            [echo.user-interface.welcome :refer [frame]]))


(defn -main
  [& _]
  (setup)
  (frame))


(comment
  (fire))

(comment
  (do (setup)
      (frame)))
