(ns echo.core
  (:require [echo.rules]
            [echo.user-interface.core :refer [setup]]
            [echo.user-interface.welcome :refer [frame]]
            [clara.tools.inspect :as inspect]
            [clara.rules :refer [fire-rules mk-session]]))


(defn -main
  [& _]
  (setup)
  (frame))


(comment
  (-> (mk-session 'echo.rules
                  :fact-type-fn :fact-type)
      (fire-rules)
      (inspect/inspect)
      :fact->explanations
      keys))

(comment
  (do (setup)
      (frame)))
