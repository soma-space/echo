(ns echo.config
  (:require [clojure-ini.core :refer [read-ini]]))


(defn get-config
  []
  (read-ini "resources/config.ini" {:keywordize? true}))
