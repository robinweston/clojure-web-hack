(ns clojure-web-hack.core.handler
  (require  [bidi.ring :refer [make-handler]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn hello-world-handler [_]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World"})

(defn user-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str "Hey " (-> request :route-params :user))})

(defn not-found-handler [request]
  {:status 404
   :headers {"Content-Type" "text/plain"}
   :body (str "404: Could not find route for " (-> request :route-params :unknown-route))})

(def routes ["/" {
                  "" hello-world-handler
                  ["user/" :user] user-handler
                  [#"(.*)" :unknown-route] not-found-handler}])

(def routes-handler
  (make-handler routes))

(def app
  (wrap-defaults routes-handler site-defaults))
