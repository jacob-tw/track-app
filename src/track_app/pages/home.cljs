(ns track-app.pages.home
  (:require [re-frame.core :as re-frame]
            [reagent.core :as r]
            [track-app.components.header :as header]
            [track-app.subs :as subs]))


(defn render []
  (let [name (re-frame/subscribe [::subs/name])
        blank-form {:username ""
                    :password ""}
        form-data (r/atom blank-form)]
    (fn []
      [:div
       [header/render]
       [:div
        {:class "flex flex-col items-center py-10"}
        [:label  "Username"]
        [:input
         {:type :text
          :class "border"
          :id :username
          :value (:username @form-data)
          :on-change #(swap! form-data assoc :username (.. % -target -value))}]
        [:label "Password"]
        [:input
         {:type :password
          :class "border"
          :value (:password @form-data)
          :on-change #(swap! form-data assoc :password (.. % -target -value))}]
        [:button
         {:class "border my-6 p-3"
          :on-click #(re-frame/dispatch [:log-in @form-data])} "Log-in"]]])))
