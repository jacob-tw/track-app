(ns track-app.pages.to-do
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]))

(defn render
  []
  (let [blank-form {:username ""
                    :password ""}]
    (fn []
      [:div {:class "h-screen bg-indigo"}
       [:div {:class "bg-blue"}
        [:h1 {:class "font-bold text-4xl p-2 text-black"} "To Do"]
        [header/render]]
       [:div {:class "bg-indigo"}]])))
