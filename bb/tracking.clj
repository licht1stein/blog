(ns tracking
  (:require
    [babashka.fs :as fs]))


(def html-file (fs/file "layouts/partials/head/link.html"))

(def tracking-code "<script async src=\"https://umami.tarka.dev/script.js\" data-website-id=\"5f018b34-1541-4166-9479-072fcadd0cf5\"></script>")


(defn append-tracking-code
  []
  (let [lines (conj (fs/read-all-lines html-file) tracking-code)]
    (fs/write-lines html-file lines)))


