(ns echo.core
  (:require [echo.rules :refer [fire session config-fact]]
            [clara.rules :refer [query]]
            [echo.queries :as queries]
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
  (-> (session [(config-fact)])
      (query queries/show-oneperone-page)))


(comment
  (do (setup)
      (oneperone-page)))

(comment
  (do (setup)
      (welcome-page)))
