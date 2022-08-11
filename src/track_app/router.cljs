(ns track-app.router
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            [reitit.frontend :as rfront]
            [reitit.coercion.spec :as rss]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]
            [track-app.views :as views]
            [track-app.pages.home :as home]
            [track-app.pages.accomplished :as accomplished]
            [track-app.pages.ongoing :as ongoing]))

(rf/reg-event-fx
 ::push-state
 (fn [_ [_ & route]]
   {:push-state route}))

(rf/reg-event-db
 ::navigated
  (fn [db [_ new-match]]
    (let [old-match   (:current-route db)
          controllers (rfc/apply-controllers (:controllers old-match) new-match)]
      (assoc db :current-route (assoc new-match :controllers controllers)))))

(rf/reg-fx
 :push-state
  (fn [route]
    (apply rfe/push-state route)))

(rf/reg-sub
 ::current-route
  (fn [db]
    (:current-route db)))

(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rfe/href k params query)))

(def routes
  ["/"
   [""
    {:name    ::home
     :view    home/render}]
   ["accomplished"
    {:name    ::accomplished
     :view    accomplished/render}]
   ["ongoing"
    {:name    ::ongoing
     :view    ongoing/render}]])

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [::navigated new-match])))

(def router
  (rfront/router
    routes
    {:data {:coercion rss/coercion}}))

(defn init-routes! []
  (rfe/start!
    router
    on-navigate
    {:use-fragment false}))
