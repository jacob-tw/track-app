(ns track-app.events
  (:require
   [re-frame.core :as re-frame]
   [track-app.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/app-db))


(re-frame/reg-event-fx
 :log-in
 (fn [{:keys [db]} [_ {:keys [username password]}]]
   (let [user (get-in db [:users username])
         correct-password? (= (get-in user [:profile :password]) password)]
     (cond
       (not user)
       {:db (assoc-in db [:errors :username] "user not found")}
       (not correct-password?)
       {:db (assoc-in db [:errors :username] "wrong password")}
       correct-password?
       {:db (-> db
                (assoc-in [:auth :uid] username)
                (update-in [:errors] dissoc :username))}))))

(re-frame/reg-event-fx
 :sign-up
 (fn [{:keys [db]} [_ {:keys [first-name last-name username password]}]]
   {:db (-> db
            (assoc-in [:auth :uid] username)
            (assoc-in [:users username ]{:id username
                                         :profile {:first-name first-name
                                                   :last-name last-name
                                                   :password password}}))}))
