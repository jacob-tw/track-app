(ns track-app.pages.accomplished
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]))


(defn render
  []
  (fn []
    [:div
     [:div {:class "bg-black text-white"}
      [header/render]]]))
