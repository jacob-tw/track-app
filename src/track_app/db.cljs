(ns track-app.db)

(def app-db
  {:name "re-frame"
   :auth {:uid nil}
   :users {"username" {:uid "first-user"
                       :profile {:first-name "default"
                                 :last-name "user"
                                 :pin-number 0000}}}})
