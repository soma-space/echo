(ns echo.user-interface.welcome
  (:require [seesaw.core :as core]
            [seesaw.font :as font]
            [seesaw.border :as border]
            [clojure.string :as str]
            [seesaw.mig :as mig]
            [echo.user-interface.core :refer [frame]
                                      :rename {frame main-frame}]))


(defn image
  [label]
  (-> label
      (core/config! :icon "test3.png")
      (core/config! :border (border/line-border :bottom 1 :top 1 :color "#DDD"))))


(defn welcome-title
  []
  (core/text :text "Myth of Soma Server Installer"
             :font (font/font :size 22 :style :bold)
             :background :white
             :border (border/empty-border :left 10 :right 10)
             :editable? false))


(defn welcome-text
  []
  (str/join "\n"
            ["This program will actively try and download"
             "and install a Myth of Soma game server"
             "to your computer."
             ""
             "In doing so it may cause misconfiguration"
             ""
             "You operate this program at your own risk"]))


(defn button-panel
  []
  (core/flow-panel :align :trailing
                   :items [(core/button :text "Next" :mnemonic \N)]))


(defn welcome-content
  []
  (core/text :text (welcome-text)
             :font (font/font :size 16)
             :editable? false
             :multi-line? true
             :background :white
             :border (border/empty-border :left 10 :right 10 :top 10)))


(defn page
  []
  (mig/mig-panel
    :items [[(image (core/label))]
            [(core/vertical-panel
               :border (border/line-border :bottom 1 :top 1 :color "#DDD")
               :items [(welcome-title)
                       (welcome-content)]) "wrap, align left, top, grow"]
            [(button-panel) "align right, bottom, span 2, grow"]]))


(defn frame
  []
  (core/pack! (core/config! (main-frame) :content (page))))
