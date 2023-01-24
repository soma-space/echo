(ns echo.queries
  (:require [clara.rules :refer [defquery]]))


(defquery show-oneperone-page
  []
  [?oneperone-page <- :oneperone-not-running])


(defquery show-welcome-page
  []
  [?welcome-page <- :show-welcome-page])
