(ns track-app.layout
  (:require [re-frame.core :as rf]))

(defn render [_]
  (fn [{:keys [_router current-route]}]
    [:div.app-container
     {:class "w-full h-screen flex flex-col"}
     (when current-route
       [(-> current-route :data :view)])]))
