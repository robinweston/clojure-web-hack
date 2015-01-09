(ns clojure-web-hack.core.handler
  (require  [bidi.ring :refer [make-handler]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn hello-world-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World!!!!"})

(def routes ["/" hello-world-handler])

(def handler
  (make-handler routes))

(def app
  (wrap-defaults handler site-defaults))
