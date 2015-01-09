(ns clojure-web-hack.core.handler
  (require  [bidi.ring :refer [make-handler]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn hello-world-handler [_]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World!!!!"})

(defn user-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str "Hey " (:user (:route-params request)))})

(def routes ["/" {
                  "" hello-world-handler
                  ["user/" :user] user-handler}])

(def routes-handler
  (make-handler routes))

(def app
  (wrap-defaults routes-handler site-defaults))
