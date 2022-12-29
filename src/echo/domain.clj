(ns echo.domain
  (:require [clojure.string :as string]
            [me.raynes.conch :as sh]))


(defn memory-64bit?
  []
  (string/ends-with? (System/getProperty "os.arch") "64"))
