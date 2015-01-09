(ns clojure-web-hack.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/user/:id/:id2" [id id2] (str "Hey " id " with surname " id2))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
