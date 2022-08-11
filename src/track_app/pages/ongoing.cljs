(ns track-app.pages.ongoing
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]))


(defn render
  []
  (fn []
    [:div
     [header/render]
     [:div "ongoing"]]))
