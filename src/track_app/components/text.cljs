(ns track-app.components.text
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent]))


(defn render
  [{:keys [input-type
           input-label
           id
           value-from-form
           on-change-event]}]
  [:div {:class "flex flex-col"}
   [:label input-label]
   [:input
    {:type input-type
     :class "border"
     :id id
     :value value-from-form
     :on-change on-change-event}]])
