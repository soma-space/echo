(ns echo.domain
  (:require [clojure.string :as string]
            [seesaw.core :as core]))


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
