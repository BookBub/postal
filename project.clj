(defproject com.github.bookbub/postal "2.0.5.3"
  :description "Clojure support for Internet email"
  :url "https://github.com/bookbub/postal"
  :license {:name "MIT"
            :url "http://en.wikipedia.org/wiki/MIT_License"
            :distribution :repo
            :comments "Use at your own risk"}
  :deploy-repositories [["releases" :clojars]]
  :dependencies [[commons-codec "1.9"]
                 [com.sun.mail/jakarta.mail "1.6.5"]]
  :global-vars {*warn-on-reflection* true}
  :profiles {:dev {:dependencies []}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :1.10 {:dependencies [[org.clojure/clojure "1.10.2"]]}}
  :aliases {"test-all" ["with-profile" "dev,1.7:dev,1.8:dev,1.9:dev,1.10" "test"]})
