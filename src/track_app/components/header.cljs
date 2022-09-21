(ns track-app.components.header
  (:require [re-frame.core :as re-frame]
            [track-app.components.buttons :as buttons]))

(defn render
  []
  [:div {:class "flex flex-row justify-end"}
   [:a
    {:href "/"
     :id "home"
     :on-click #(re-frame/dispatch [::push-state ::home])
     :class "border px-2"} "Home"]
   [:a
    {:href "accomplished"
     :id "accomplished"
     :on-click #(re-frame/dispatch [::push-state ::accomplished])
     :class "border px-2"} "Track Accomplished"]
   [:a
    {:href "new-patient"
     :id "new-patient"
     :on-click #(re-frame/dispatch [::push-state ::new-patient])
     :class "border px-2"} "New Patient"]
   [:a
    {:href "signup"
     :id "signup"
     :on-click #(re-frame/dispatch [::push-state ::signup])
     :class "border px-2"} "Sign Up"]])
