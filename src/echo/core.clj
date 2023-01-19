(ns echo.core
  (:require [echo.rules :refer [fire]]
            [echo.user-interface :refer [setup]]
            [echo.user-interface.welcome :refer [display-frame]]))


(defn -main
  [& _]
  (setup)
  (display-frame))


(comment
  (fire))

(comment
  (do (setup)
      (display-frame)))
