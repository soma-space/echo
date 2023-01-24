(ns echo.interface.oneperone
  (:require [seesaw.core :as core]
            [echo.interface :refer [main-frame]]))


(defn oneperone-page
  []
  (core/pack! (core/config! (main-frame) :content (core/text "hi"))))
