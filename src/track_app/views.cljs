(ns track-app.views
  (:require
   [re-frame.core :as re-frame]
   [track-app.subs :as subs]
   [track-app.layout :as layout]))

(defn main
  [_]
  (fn [{:keys [router]}]
    (let [current-route (re-frame/subscribe [:track-app.router/current-route])]
      [layout/render       {:router router
                   :current-route @current-route}])))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    (fn []
      [:div
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



(defn other-panel []
  (fn []
    [:div "other panel"
     [:header
      [:nav
       [:a
        {:href "/"
        :on-click #(re-frame/dispatch [::push-state ::home])} "hey"]]]]))
