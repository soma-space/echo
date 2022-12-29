(ns echo.user-interface.core
  (:require [seesaw.core :as core]))


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


(comment
  (reset! frame! nil))
