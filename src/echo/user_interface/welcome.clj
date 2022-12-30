(ns echo.user-interface.welcome
  (:require [seesaw.core :as core]
            [seesaw.font :as font]
            [seesaw.border :as border]
            [clojure.string :as str]
            [seesaw.mig :as mig]
            [echo.user-interface.core :refer [frame]
             :rename {frame main-frame}])
  (:import (java.awt Insets)))


(defn image
  [label]
  (core/config! label :icon "test3.png"))


(defn welcome-title
  []
  (core/text :text "Myth of Soma Server Installer"
             :font (font/font :size 22 :style :bold)
             :background :white
             :border (border/empty-border :left 20 :right 20)
             :editable? false))


(defn welcome-text
  []
  (str/join "\n"
            ["This program will try to download and install"
             "a Myth of Soma game server to your computer."
             ""
             "In doing so it may cause misconfiguration."
             ""
             "You operate this program at your own risk."]))


(defn button-panel
  []
  (core/horizontal-panel
    :border (border/line-border :top 1 :color "#CCC")
    :items [(core/horizontal-panel
              :border (border/line-border :top 1 :color :white)
              :items [(core/flow-panel :align :trailing
                                       :border (border/empty-border :top 5 :left 5 :right 5 :bottom 5)
                                       :items [(core/button :text "Next >" :font (font/font :size 16) :mnemonic \N :margin (Insets. 6 20 6 20))])])]))


(defn welcome-content
  []
  (core/text :text (welcome-text)
             :font (font/font :size 16)
             :editable? false
             :multi-line? true
             :background :white
             :border (border/empty-border :left 20 :right 20)))


(defn page
  []
  (mig/mig-panel
    :constraints ["gap 0, insets 0"]
    :items [[(image (core/label))]
            [(core/vertical-panel
               :items [(welcome-title)
                       (welcome-content)]) "wrap, align left, top, grow"]
            [(button-panel) "align right, bottom, span 2, grow"]]))


(defn frame
  []
  (core/pack! (core/config! (main-frame) :content (page))))
