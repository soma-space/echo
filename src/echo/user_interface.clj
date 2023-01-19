(ns echo.user-interface
  (:require [seesaw.core :as core]))


(def frame! (atom nil))


(defn setup
  []
  (core/native!))


(defn frame
  []
  (or @frame!
      (reset! frame!
              (core/frame :title "Myth of Soma Server Installer"
                          :icon "symbol.png"
                          :resizable? false
                          :visible? true))))
                          ;:on-close :exit))))


(comment (reset! frame! nil))
