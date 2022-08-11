(ns track-app.components.header
  (:require [re-frame.core :as re-frame]
            [track-app.components.buttons :as buttons]))

(defn render
  []
  [:div {:class "flex flex-row justify-end"}
   [:a {:href "/"}
    [buttons/header-button
     {:id "home"
      :button-label "Home"
      :on-click #(re-frame/dispatch [::push-state ::home])}]]
   [:a {:href "accomplished"}
    [buttons/header-button
     {:id "accomplished"
      :button-label "Track Accomplished"
      :on-click #(re-frame/dispatch [::push-state ::accomplished])
      :href "accomplished"}]]
   [:a {:href "ongoing"}
    [buttons/header-button
     {:id "ongoing"
      :button-label "Track Ongoing"
      :on-click #(re-frame/dispatch [::push-state ::ongoing])}]]])
