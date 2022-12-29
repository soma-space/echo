(ns echo.main
  (:require [echo.rules]
            [echo.user-interface :refer [setup main-frame]]
            [clara.tools.inspect :as inspect]
            [clara.rules :refer [fire-rules mk-session]]))


(defn -main [& _]
  (setup)
  (main-frame))


(comment
  (-> (mk-session 'echo.rules
                  :fact-type-fn :fact-type)
      (fire-rules)
      (inspect/inspect)
      :fact->explanations
      keys))
