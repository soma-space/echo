(ns echo.user-interface.core
  (:require [seesaw.core :as core]
            [seesaw.font :as font]
            [echo.domain :refer [next-action]])
  (:import (java.awt Insets)))


(defn setup
  []
  (core/native!))


(def frame! (atom nil))


(defn frame
  []
  (or @frame!
      (reset! frame!
              (core/frame :title "Myth of Soma Server Installer"
                          :icon "symbol3.png"
                          :resizable? false
                          :visible? true
                          :on-close :exit))))


(comment (reset! frame! nil))


(defn next-button
  []
  (let [button (core/button :text "Next >"
                            :font (font/font :size 16)
                            :mnemonic \N
                            :margin (Insets. 6 20 6 20))]
    (core/listen button :action next-action)
    button))
