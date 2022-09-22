(ns track-app.components.header
  (:require [re-frame.core :as re-frame]
            [track-app.components.buttons :as buttons]))

(defn render
  []
  [:div {:class "flex flex-row justify-end"}
   [:a
    {:href "/"
     :id "active-patients"
     :on-click #(re-frame/dispatch [::push-state ::active-patients])
     :class "border px-2"} "Active Patients"]
   [:a
    {:href "new-patient"
     :id "new-patient"
     :on-click #(re-frame/dispatch [::push-state ::new-patient])
     :class "border px-2"} "New Patient"]
   [:a
    {:href "to-do-list"
     :id "to-do-list"
     :on-click #(re-frame/dispatch [::push-state ::to-do-list])
     :class "border px-2"} "To Do"]
   [:a
    {:href "profile"
     :id "profile"
     :on-click #(re-frame/dispatch [::push-state ::profile])
     :class "border px-2"} "Profile"]])
