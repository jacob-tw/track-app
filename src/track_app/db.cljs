(ns track-app.db)

(def app-db
  {:name "re-frame"
   :auth {:uid nil}
   :users {"unluckywarrior" {:uid "unluckywarrior"
                             :profile {:first-name "default"
                                       :last-name "user"
                                       :password "ratnose1"}}}})
