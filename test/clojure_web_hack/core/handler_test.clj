(ns clojure-web-hack.core.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-web-hack.core.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "user route"
    (let [response (app (mock/request :get "/user/testUser"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hey testUser"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
