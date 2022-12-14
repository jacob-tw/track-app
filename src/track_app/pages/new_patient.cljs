(ns track-app.pages.new-patient
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]
            [reagent.core :as r]
            [track-app.components.text :as text]
            [track-app.components.buttons :as button]))

;; 1) goal is to convert this page into the "command-center"

;; 2) functionality on this page - take input from user (fname lname bday poc start-date)
;;                               - persist input in db
;;                               - display of patient db (past and present) - ability to filter - can interract with their "file" (for attendance, ?charts, ?sup-doc)


(defn render
  []
  (let [blank-form {:first-name ""
                    :last-name ""
                    :initial-assessment ""
                    :poc ""
                    :poc-end-date ""
                    :claim-number ""
                    :dob ""}
        form-data (r/atom blank-form)]
    (fn []
      [:div {:class "h-screen bg-indigo"}
       [:div {:class "border bg-blue"}
        [:h1 {:class "font-bold text-4xl p-2 text-black"} "New Patient"]
        [header/render]]
       [:div {:class "grid grid-flow-row gap-2 p-2 justify-items-center bg-indigo text-mygray h-4/5"}
        [:div {:class "grid w-2/5"}
         [:h1 {:class "font-bold text-3xl mb-5"} "Patient Info"]
         [text/render
          {:input-type :text
           :input-label "First-name"
           :id :first-name
           :value-from-form (:first-name @form-data)
           :on-change-event #(swap! form-data assoc :first-name (.. % -target -value))}]
         [text/render
          {:input-type :text
           :input-label "Last-name"
           :id :last-name
           :value-from-form (:last-name @form-data)
           :on-change-event #(swap! form-data assoc :last-name (.. % -target -value))}]
         [text/render
          {:input-type :date
           :input-label "DOB"
           :id :dob
           :value-from-form (:dob @form-data)
           :on-change-event #(swap! form-data assoc :dob (.. % -target -value))}]]
        [:div {:class "grid w-2/5"}
         [:h1 {:class "font-bold text-3xl mb-5"} "WSIB claim info"]
         [text/render
          {:input-type :date
           :input-label "Initial Assessment"
           :id :initial-assessment
           :value-from-form (:initial-assessment @form-data)
           :on-change-event #(swap! form-data assoc :initial-assessment (.. % -target -value))}]
         [text/render
          {:input-type :text
           :input-label "Program of care (POC)"
           :id :poc
           :value-from-form (:poc @form-data)
           :on-change-event #(swap! form-data assoc :poc (.. % -target -value))}]
         [text/render
          {:input-type :date
           :input-label "POC end date"
           :id :poc-end-date
           :value-from-form (:poc-end-date @form-data)
           :on-change-event #(swap! form-data assoc :poc-end-date (.. % -target -value))}]
         [text/render
          {:input-type :text
           :input-label "WSIB claim number"
           :id :claim-number
           :value-from-form (:claim-number @form-data)
           :on-change-event #(swap! form-data assoc :claim-number (.. % -target -value))}]]]
       [:div {:class "grid justify-items-center bg-indigo"}
         [button/form-button
          {:id :submit
           :button-label "submit"
           :on-click #(re-frame/dispatch [:add-to-app-db @form-data])
           :class "p-3 font-bold text-2xl border-4 text-mygray"}]]])))
