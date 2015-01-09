(ns clojure-web-hack.core.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-web-hack.core.handler :refer :all]))

(defn get-response [request-url] (app (mock/request :get request-url)))

(deftest test-app
  (testing "main route"
    (let [response (get-response "/")]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "user route"
    (let [response (get-response "/user/testUser")]
      (is (= (:status response) 200))
      (is (= (:body response) "Hey testUser"))))

  (testing "not-found route"
    (let [response (get-response "/whatever")]
      (is (= (:status response) 404)))))
