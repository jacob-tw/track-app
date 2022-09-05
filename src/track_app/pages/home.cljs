(ns track-app.pages.home
  (:require [re-frame.core :as re-frame]
            [reagent.core :as r]
            [track-app.components.header :as header]
            [track-app.subs :as subs]
            [track-app.components.text :as text]))


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

(defn signup-render []
  (let [blank-form {:first-name ""
                    :last-name ""
                    :username ""
                    :password ""}
        form-data (r/atom blank-form)]
    (fn []
      [:div {:class "flex flex-col"}
       [header/render]
       [:div {:class "flex flex-col items-center mt-20"}]
       [:div {:class "flex flex-col items-center p-2 my-1"}
        [:h1
         {:class "font-bold text-3xl mb-5"} "Create Account"]
        [text/render
         {:input-type :text
          :input-label "First Name"
          :id :first-name
          :value-from-form (:first-name @form-data)
          :on-change-event #(swap! form-data assoc :first-name (.. % -target -value))}]
        [text/render
         {:input-type :text
          :input-label "Last Name"
          :id :last-name
          :value-from-form (:last-name @form-data)
          :on-change-event #(swap! form-data assoc :last-name (.. % -target -value))}]
        [text/render
         {:input-type :text
          :input-label "Username"
          :id :username
          :value-from-form (:username @form-data)
          :on-change-event #(swap! form-data assoc :username (.. % -target -value))}]
        [text/render
         {:input-type :password
          :input-label "Password"
          :id :password
          :value-from-form (:password @form-data)
          :on-change-event #(swap! form-data assoc :password (.. % -target -value))}]
        [:div
         [:button
          {:class "border my-6 p-3"
           :on-click #(re-frame/dispatch [:sign-up @form-data])} "Sign-up"]]]])))
