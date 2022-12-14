(ns track-app.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [track-app.events :as events]
   [track-app.views :as views]
   [track-app.config :as config]
   [track-app.router :as router]
   [track-app.pages.home :as home]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main {:router router/router}] root-el)))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (router/init-routes!)
  (mount-root))
