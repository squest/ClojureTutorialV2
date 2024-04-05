(ns app.list.remake)

(defn my-last
  [[x & xs]]
  (if (empty? xs)
    x
    (my-last xs)))

;; Practical clojure curriculum

;; TODO 1: lein new app, understanding ns and require including dependencies
;; TODO 2: Understanding json to edn and file io
;; TODO 3: Create in-memory database using atom & file-based database, remake CRUD and basic query functions
;; TODO 4: Use monger & sqlite to create a simple database
;; TODO 5: Create a simple web server using ring, ring-defaults, and reitit

;; CRUD functionalities

;; Create a collection
;; Add a document to a collection, with auto-generated id
;; Add multiple docs to a collection
;; Read a document from a collection based on the id
;; Find some docs based on a query {key value} {:name "John"}
;; Read all documents from a collection
;; Update a document in a collection based on the id
;; Delete a document from a collection based on the id
;; Delete multiple docs based on the ids
;; note, id is a generated uuid, and it's a string
