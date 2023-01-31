(ns echo.core
  (:require [echo.rules :refer [fire]]
            [echo.interface :refer [setup]]
            [echo.interface.welcome :refer [welcome-page]]
            [echo.interface.oneperone :refer [oneperone-page]]))


(defn -main
  [& _]
  (setup)
  (welcome-page))


(comment
  (fire))


(comment
  (do (setup)
      (oneperone-page)))


(comment
  (do (setup)
      (welcome-page)))
