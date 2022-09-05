(ns track-app.pages.ongoing
  (:require [re-frame.core :as re-frame]
            [track-app.subs :as subs]
            [track-app.components.header :as header]
            [reagent.core :as r]
            [track-app.components.text :as text]))

;; 1) goal is to convert this page into the "command-center"

;; 2) functionality on this page - take input from user (fname lname bday poc start-date)
;;                               - persist input in db
;;                               - display of patient db (past and present) - ability to filter - can interract with their "file" (for attendance, ?charts, ?sup-doc)


(defn render
  []
  (let [blank-form {:first-name ""
                    :last-name ""
                    :start-date ""
                    :poc ""}
        form-data (r/atom blank-form)]
    (fn []
      [:div
       [header/render]
       [:div {:class "grid grid-rows-3 grid-flow-col gap-4 p-2"}
        [:div {:class "row-span-3"}
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
          {:input-type :text
           :input-label "Program of care (POC)"
           :id :poc
           :value-from-form (:poc @form-data)
           :on-change-event #(swap! form-data assoc :poc (.. % -target -value))}]
         [text/render
          {:input-type :date
           :input-label "Start-date"
           :id :Start-date
           :value-from-form (:start-date @form-data)
           :on-change-event #(swap! form-data assoc :start-date (.. % -target -value))}]]
        [:div {:class "col-span-2"}
         [:h1 {:class "font-bold text-3xl mb-5"} "command-center"]]
        [:div {:class "row-span-2 col-span-2 bg-black"}]]])))
