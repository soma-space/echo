(ns echo.interface
  (:require [seesaw.core :as core]))


(def frame! (atom nil))


(defn setup
  []
  (core/native!))


(defn frame
  []
  (let [frame (core/frame :title "Myth of Soma Server Installer"
                          :icon "symbol.png"
                          :resizable? false
                          :visible? true
                          :on-close :dispose)]
    (core/listen frame :window-closed (fn [_] (reset! frame! nil)))
    frame))


(defn main-frame
  []
  (or @frame! (frame)))
