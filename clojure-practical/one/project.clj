(defproject one "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [danlentz/clj-uuid "0.1.9"]
                 [cheshire "5.13.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [org.xerial/sqlite-jdbc "3.23.1"]]
  :repl-options {:init-ns one.core})
