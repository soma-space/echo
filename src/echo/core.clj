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
  (let [session (session [(config-fact)])]
    (distinct
      (map first
           (mapcat first (filter seq [(query session queries/show-oneperone-page)
                                      (query session queries/show-oneperone-page)
                                      (query session queries/show-welcome-page)]))))))


    ;(map first (query session queries/show-oneperone-page)
    ;           (query session queries/show-welcome-page))))

; '({?blah {:fact :blah])
; '()

(comment
  (do (setup)
      (oneperone-page)))

(comment
  (do (setup)
      (welcome-page)))
