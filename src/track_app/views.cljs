(ns track-app.views
  (:require
   [re-frame.core :as re-frame]
   [track-app.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Hello from " @name]
     ]))
