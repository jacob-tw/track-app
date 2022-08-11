(ns track-app.pages.home
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]))


(defn render []
  (let [name (re-frame/subscribe [::subs/name])]
    (fn []
      [:div
       [header/render]
       [:header
        "Hello from " @name
        [:nav {:class "flex justify-between"}

         [:label {:class "flex flex-col"} "username"
          [:input
           {:type :text
            :class "border"}]]
         [:label
          {:class "flex flex-col"}"password"
          [:input
           {:type :password
            :class "border"}]]

         [:a
          {:href "other1"
           :on-click #(re-frame/dispatch [::push-state ::other])}"hello"]]]])))
