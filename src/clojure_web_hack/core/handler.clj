(ns clojure-web-hack.core.handler
  (require  [bidi.ring :refer [make-handler]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn hello-world-handler [_]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World!!!!"})

(defn robin-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str "Hey Robin. You came from " (:remote-addr request) )})

(def routes ["/" {
                  "" hello-world-handler
                  "robin" robin-handler}])

(def handler
  (make-handler routes))

(def app
  (wrap-defaults handler site-defaults))
