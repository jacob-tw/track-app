(ns track-app.components.buttons
  (:require
   [re-frame.core :as re-frame]
   [track-app.events :as events]
   [track-app.subs :as subs]))


(defn header-button
  [{:keys [button-label
           id
           on-click]}]
  [:button
   {:id id
    :on-click on-click
    :class "px-2 border"} button-label])

(defn form-button
  [{:keys [button-label
           id
           on-click
           class]}]
  [:button
   {:id id
    :on-click on-click
    :class (str "px-2 py-1 my-3 border"
                class)} button-label])
