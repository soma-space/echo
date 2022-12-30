(ns echo.domain
  (:require [clojure.string :as string]
            [clara.tools.inspect :as inspect]
            [clara.rules :refer [fire-rules mk-session]]
            [me.raynes.conch :as sh]))


(defn memory-64bit?
  []
  (string/ends-with? (System/getProperty "os.arch") "64"))


(defn next-action
  [e]
  (core/alert e "TODO!!"))

;(defn next-action
;  []
;  (let [rules (-> (mk-session 'echo.rules
;                              :fact-type-fn :fact-type)
;                  (fire-rules)
;                  (inspect/inspect)
;                  :fact->explanations
;                  keys)]
;    (println rules)))
