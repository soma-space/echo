(ns echo.core
  (:require [echo.rules :refer [fire]]
            [echo.user-interface :refer [setup]]
            [echo.user-interface.welcome :refer [welcome-frame]]))


(defn -main
  [& _]
  (setup)
  (welcome-frame))


(comment
  (fire))

(comment
  (do (setup)
      (welcome-frame)))
