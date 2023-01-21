(ns echo.interface.buttons
  (:require [seesaw.core :as core]
            [seesaw.font :as font]
            [echo.interface.actions :refer [next-action]])
  (:import (java.awt Insets)))


(defn next-button
  []
  (let [button (core/button :text "Next >"
                            :font (font/font :size 16)
                            :mnemonic \N
                            :margin (Insets. 6 20 6 20))]
    (core/listen button :action next-action)
    button))
